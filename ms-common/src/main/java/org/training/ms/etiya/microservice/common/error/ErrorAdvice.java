package org.training.ms.etiya.microservice.common.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @Value("${app.micro.name}")
    private String microserviceName;

    public RestErrorObj createBaseError() {
        return RestErrorObj.createError(microserviceName);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(IllegalArgumentException exp) {
        return createBaseError().setDesc(exp.getMessage())
                                .setCode(1001);
    }

    @ExceptionHandler(IllegalCallerException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public RestErrorObj handle(IllegalCallerException exp) {
        return createBaseError().setDesc(exp.getMessage())
                                .setCode(1001);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(MethodArgumentNotValidException exp) {
        return createBaseError().setDesc("Validasyon problemi")
                                .setCode(1047)
                                .addSubErrors(exp.getAllErrors()
                                                 .stream()
                                                 .map(oe -> createBaseError().setDesc(oe.toString())
                                                                             .setCode(1048))
                                                 .collect(Collectors.toList()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(ConstraintViolationException exp) {
        return createBaseError().setDesc("Validasyon problemi")
                                .setCode(1047)
                                .addSubErrors(exp.getConstraintViolations()
                                                 .stream()
                                                 .map(oe -> createBaseError().setDesc(oe.toString())
                                                                             .setCode(1048))
                                                 .collect(Collectors.toList()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorObj> handle(Exception exp) {
        exp.printStackTrace();
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .header("exp",
                                         exp.getClass()
                                            .getName())
                                 .body(createBaseError().setDesc(exp.getMessage())
                                                        .setCode(1001));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("exp",
                                     exp.getClass()
                                        .getName())
                             .body(createBaseError().setDesc(exp.getMessage())
                                                    .setCode(1002));
    }


}
