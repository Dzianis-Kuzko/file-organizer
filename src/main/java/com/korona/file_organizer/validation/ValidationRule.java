package com.korona.file_organizer.validation;

public interface ValidationRule<T> {
    void validate(T t);
}
