package org.training.ms.etiya.microservice.common.error;


import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class RestErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey,
                            Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        RestErrorObj restErrorObj = null;
        try {
            restErrorObj = objectMapper.readValue(response.body()
                                                                       .asInputStream(),
                                                               RestErrorObj.class);
            return new RestException(restErrorObj);
        } catch (Exception e) {
            return new RestException();
        }
    }

}
