package com.korona.file_organizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PositionalParam<T> {
    private T value;
    private int position;
}
