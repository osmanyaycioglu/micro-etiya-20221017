package org.training.ms.etiya.msorder.services.integrations;

import org.training.ms.etiya.microservice.common.error.RestErrorObj;
import org.training.ms.etiya.microservice.common.error.RestException;

import java.util.function.Predicate;

public class RetryExceptionChoose implements Predicate<Throwable> {

    @Override
    public boolean test(Throwable throwable) {
        if (throwable instanceof RestException){
            RestException exception = (RestException) throwable;
            RestErrorObj restErrorObj = exception.getRestErrorObj();
            if (restErrorObj != null){
                Integer code = restErrorObj.getCode();
                switch (code) {
                    case 1024:
                    case 1025:
                    case 1048:
                    case 1049:
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

}
