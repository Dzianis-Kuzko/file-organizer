package com.korona.file_organizer.repository.impl;

import com.korona.file_organizer.repository.Repository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InvalidDataRepository implements Repository<String> {
    private final List<String> invalidData = new ArrayList<>();

    @Override
    public void add(String invalidString) {
        invalidData.add(invalidString);
    }
}
