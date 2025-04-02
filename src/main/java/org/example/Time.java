package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public void Time() {
        LocalDateTime now = LocalDateTime.now();

        String formatt = now.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));
        System.out.println(formatt);
    }
}
