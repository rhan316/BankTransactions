package com.example.bank.model;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public LocalDateTime unmarshal(String s) {
        return (s != null ? LocalDateTime.parse(s, formatter) : null);
    }

    @Override
    public String marshal(LocalDateTime ldt) {
        return (ldt != null ? ldt.format(formatter) : null);
    }
}
