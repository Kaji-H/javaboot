package com.kajih.practice19_2;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice19_2.Config.GameConfig;
import com.kajih.practice19_2.Config.Message;

public class Choices {

    private List<String> choices = new ArrayList<>();

    public Choices(String... text) {
        for (String choice : text) {
            this.choices.add(choice);
        }
    }

    public void showChoices(int selectNum) {
        System.out.printf(Message.CHOICES, selectNum, choices.get(selectNum - 1));
    }

    public void showAllChoices() {
        for (int i = GameConfig.MIN_CHOICES; i <= choices.size(); i++) {
            showChoices(i);
        }
    }

    public int getSelectNum(String text) {
        return choices.indexOf(text) + 1;
    }
}
