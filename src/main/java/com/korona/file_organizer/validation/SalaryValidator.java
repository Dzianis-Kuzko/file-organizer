package com.korona.file_organizer.validation;

import java.math.BigDecimal;

public class SalaryValidator {
    public boolean isValid(BigDecimal salary) {
        return salary.compareTo(BigDecimal.ZERO) > 0;

    }
}

