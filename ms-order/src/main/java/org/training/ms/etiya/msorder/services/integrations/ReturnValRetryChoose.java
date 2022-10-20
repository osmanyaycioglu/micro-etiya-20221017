package org.training.ms.etiya.msorder.services.integrations;

import java.util.function.Predicate;

public class ReturnValRetryChoose implements Predicate<String> {

    @Override
    public boolean test(String s) {
        if ("osman".equals(s)){
            return true;
        }

        return false;
    }

}
