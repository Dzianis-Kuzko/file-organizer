package com.korona.file_organizer.util;

import com.korona.file_organizer.model.enums.Valued;

import java.util.Arrays;
import java.util.Optional;

public final class ArgParserUtil {
    public static final String PARAM_VALUE_SEPARATOR = "=";

    private ArgParserUtil() {
    }

    public static <T extends Enum<T> & Valued> boolean isValidParamWithValue(String arg, Class<T> enumFlagType) {
        return Arrays.stream(enumFlagType.getEnumConstants())
                .map(Valued::getValue)
                .anyMatch(value -> arg.startsWith(value + PARAM_VALUE_SEPARATOR));
    }


    public static String extractValue(String arg) {
        int separatorIndex = arg.indexOf(PARAM_VALUE_SEPARATOR);
        if (separatorIndex == -1 || separatorIndex == arg.length() - 1) {
            throw new IllegalArgumentException("Arg должен содержать значение: " + arg);
        }
        return arg.substring(separatorIndex + 1);
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
