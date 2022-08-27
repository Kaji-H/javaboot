package com.kajih.practice19_2;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice19_2.Config.Message;

public class Log {

    private List<String> log = new ArrayList<>();

    public void setRecordOfDay(int day, int hp, String food, int danger, String action) {
        String word = String.format(Message.STANDARD_FORM_OF_RECORD, day, hp, food, danger, action);
        this.log.add(word);
    }

    public void show() {
        System.out.printf(Message.LOG_START);

        for (String word : this.log) {
            System.out.printf(word);
        }

        System.out.printf(Message.LOG_END);
    }
}
