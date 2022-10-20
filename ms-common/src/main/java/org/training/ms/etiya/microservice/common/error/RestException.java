package org.training.ms.etiya.microservice.common.error;

public class RestException extends RuntimeException {

    private RestErrorObj restErrorObj;

    public RestException(RestErrorObj restErrorObj) {
        super(restErrorObj.getDesc());
        this.restErrorObj = restErrorObj;
    }

    public RestException() {
    }

    public RestErrorObj getRestErrorObj() {
        return restErrorObj;
    }

    public void setRestErrorObj(RestErrorObj restErrorObj) {
        this.restErrorObj = restErrorObj;
    }
}
