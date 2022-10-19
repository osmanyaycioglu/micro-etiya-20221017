package org.training.ms.etiya.msorder.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Optional;

public class ContainsStringImpl implements ConstraintValidator<ContainsString, String> {

    private ContainsString anno;

    @Override
    public void initialize(ContainsString anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(String strValue,
                           ConstraintValidatorContext context) {

        return !Arrays.stream(anno.value())
                     .anyMatch(strValue::contains);
    }
}
