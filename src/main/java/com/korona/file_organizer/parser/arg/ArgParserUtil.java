package com.korona.file_organizer.parser.arg;

import com.korona.file_organizer.config.enums.impl.Valued;

import java.util.Arrays;
import java.util.Optional;

public final class ArgParserUtil {
    public static final String PARAM_VALUE_SEPARATOR = "=";

    private ArgParserUtil() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static <T extends Enum<T> & Valued> Optional<T> tryParseValue(String value, Class<T> enumValueType) {
        if (value == null) {
            return Optional.empty();
        }

        return Arrays.stream(enumValueType.getEnumConstants())
                .filter(constant -> value.equals(constant.getValue()))
                .findFirst();
    }
}
