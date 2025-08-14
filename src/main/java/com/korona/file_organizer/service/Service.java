package com.korona.file_organizer.service;

import java.util.Optional;

public interface Service<T> {
    Optional<T> add(T t);
}

