package com.korona.file_organizer.parser;

/**
 * A generic interface that defines a contract for parsing objects
 * of one type into objects of another type.
 *
 * @param <T> the type of the input to be parsed
 * @param <R> the type of the result after parsing
 */
public interface Parser<T, R> {
    R parse(T t);
}
