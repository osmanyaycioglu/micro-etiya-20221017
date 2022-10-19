package org.training.ms.etiya.msorder.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Constraint(validatedBy = { ContainsStringImpl.class })
public @interface ContainsString {

    String[] value();

    String message() default "{javax.validation.constraints.ContainsString.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
