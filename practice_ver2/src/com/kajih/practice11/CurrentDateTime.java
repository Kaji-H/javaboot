package com.kajih.practice11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("現在の日時: yyyy 年 MM 月 dd 日 HH 時 mm 分");
        System.out.println(format.format(now));
    }
}
