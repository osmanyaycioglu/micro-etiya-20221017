package org.training.ms.etiya.microservice.common.error;

import java.util.ArrayList;
import java.util.List;

public class RestErrorObj {

    private List<RestErrorObj> subErrors;
    private String             microservice; // domain.subdomain.boundedcontext.microservice
    private String             desc;
    private Integer            code;

    public static RestErrorObj createError() {
        return new RestErrorObj();
    }

    public static RestErrorObj createError(String microservice) {
        return new RestErrorObj().setMicroservice(microservice);
    }

    public List<RestErrorObj> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<RestErrorObj> subErrors) {
        this.subErrors = subErrors;
    }

    public RestErrorObj addSubError(RestErrorObj restErrorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();

        }
        subErrors.add(restErrorObj);
        return this;
    }

    public RestErrorObj addSubErrors(List<RestErrorObj> restErrorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();

        }
        subErrors.addAll(restErrorObj);
        return this;
    }

    public String getMicroservice() {
        return microservice;
    }

    public RestErrorObj setMicroservice(String microservice) {
        this.microservice = microservice;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public RestErrorObj setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public RestErrorObj setCode(Integer code) {
        this.code = code;
        return this;
    }

    public static void main(String[] args) {
        RestErrorObj.createError()
                    .setMicroservice("d.s.b.ms1")
                    .setDesc("xyz")
                    .setCode(1020)
                    .addSubError(RestErrorObj.createError()
                                             .setMicroservice("d.s.b.ms1")
                                             .setDesc("abc")
                                             .setCode(1021))
                    .addSubError(RestErrorObj.createError()
                                             .setMicroservice("d.s.b.ms1")
                                             .setDesc("kjh")
                                             .setCode(1022)
                                             .addSubError(RestErrorObj.createError()
                                                                      .setMicroservice("d.s.b.ms1")
                                                                      .setDesc("dfjhfd")
                                                                      .setCode(10222)));

    }
}
