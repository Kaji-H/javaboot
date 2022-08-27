package com.kajih.practice19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kajih.practice19.Config.GameConfig;
import com.kajih.practice19.Config.Message;

public class UnpopulatedIsland {

    private Message MESSAGE = new Config().new Message();
    private GameConfig CONFIG = new Config().new GameConfig();
    private Random RAND = new Random();

    private int days;
    private int hint;
    private Player player;
    private List<FoodList> foodList;
    private List<String> log = new ArrayList<>();

    public UnpopulatedIsland(Player player) {
        this.player = player;
        this.days = CONFIG.INIT_DAYS;
        this.hint = CONFIG.MAX_HINT_TIME;
        this.foodList = initFoodList();
    }

    public void showPrologue() {
        System.out.printf(MESSAGE.PROLOGUE, CONFIG.MAX_DAYS);
        System.out.printf(MESSAGE.NEWLINE);
    }

    public void spend() {
        if (isClear(this.days)) {
            return;
        }

        FoodList food = this.foodList.get(this.days - 1);

        showDay(this.days);
        showFood(food);

        showHP(this.player.getHp());
        showEatOrNot();
        showChoices();

        int select = selectPlayer();

        if (hasSelectedHint(select)) {

            FoodList nextFood = this.foodList.get(this.days);
            showNextFood(nextFood);
            this.hint--;

        } else {

            playEatingAction(select, food);

            writeLog(this.days, this.player.getHp(), food, select);

            if (this.player.isDeath()) {
                return;
            }
            this.days++;
        }

        spend();
        return;
    }

    public void showEnding() {
        if (this.player.isDeath()) {
            String causeOfDeath = this.player.getCauseOfDeath();

            System.out.printf(MESSAGE.BAD_END, causeOfDeath);
            System.out.printf(MESSAGE.NEWLINE);
            return;
        }

        System.out.printf(MESSAGE.ENDING, CONFIG.MAX_DAYS);
        System.out.printf(MESSAGE.NEWLINE);
        return;
    }

    public void showLog() {
        System.out.printf(MESSAGE.LOG);

        for (String line : this.log) {
            System.out.println(line);
        }
    }

    private List<FoodList> initFoodList() {
        List<FoodList> list = new ArrayList<>();

        for (int i = 0; i < CONFIG.MAX_DAYS; i++) {
            int foodId = RAND.nextInt(FoodList.values().length);
            list.add(FoodList.toEnum(foodId));

            System.out.println(list.get(i).getName());
        }
        return list;
    }

    private int selectPlayer() {
        String select = this.player.input();

        int num = validate(select);

        return num;
    }

    private int validate(String select) {
        if (!isNum(select)) {
            showWarningToInputNonNumeric();
            return selectPlayer();
        }

        int num = Integer.parseInt(select);

        if (!isChoicesRange(num)) {
            showWarningToInputOutOfChoices();
            return selectPlayer();
        }
        return num;
    }

    private void playEatingAction(int select, FoodList food) {
        if (!hasSelectedToEat(select)) {
            this.player.decreseHpWhenHungry();
            return;
        }

        if (this.player.canEat(food.getDangerLevel())) {

            this.player.recoverHp(food.getAmountOfRexovery());
            return;
        }

        this.player.sufferFromFoodPoisoning(food.getCauseOfDeath());
        return;
    }

    private void writeLog(int day, int hp, FoodList food, int select) {
        String action = setPlayerAction(select);
        // text = String.format(MESSAGE.RECORD,
        // day, hp, food.getName(), food.getDangerLevel(), action);
        String text = action;
        log.add(text);
    }

    private String setPlayerAction(int select) {
        if (hasSelectedToEat(select)) {
            return MESSAGE.EAT;
        }
        return MESSAGE.NOT_EAT;
    }

    private void showEatOrNot() {
        System.out.printf(MESSAGE.EAT_OR_NOT);
    }

    private void showHP(int hp) {
        System.out.printf(MESSAGE.PLAYERS_HP, hp);
    }

    private void showChoices() {
        System.out.printf(MESSAGE.CHOICES_TO_EAT);

        if (canUseHint()) {
            System.out.printf(MESSAGE.HINT_CHOICES);
        }

        System.out.printf(MESSAGE.NEWLINE);
    }

    private void showDay(int day) {
        System.out.printf(MESSAGE.DATE, day);
    }

    private void showFood(FoodList food) {
        System.out.printf(MESSAGE.FOOD_DATA,
                food.getName(),
                food.getAmountOfRexovery(),
                food.getDangerLevel());
    }

    private void showNextFood(FoodList food) {

        System.out.printf(MESSAGE.TOMMOROW_FOOD);

        showFood(food);

        System.out.printf(MESSAGE.NEWLINE);
    }

    private void showWarningToInputNonNumeric() {
        System.out.printf(MESSAGE.WARREING_TO_INPUT_NON_NUMERIC);
    }

    private void showWarningToInputOutOfChoices() {
        System.out.printf(MESSAGE.WARRNING_TO_INPUT_OUT_OF_CHOICES);
    }

    private boolean isClear(int day) {
        return day > CONFIG.MAX_DAYS;
    }

    private boolean canUseHint() {
        return this.hint > CONFIG.MIN_HINT_TIME;
    }

    private boolean isChoicesRange(int num) {
        int maxChoices = CONFIG.MAX_CHOICES;

        if (!canUseHint()) {
            maxChoices--;
        }

        return num <= maxChoices && num >= CONFIG.MIN_CHOICES;
    }

    private boolean isNum(String select) {
        try {
            Integer.parseInt(select);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean hasSelectedHint(int select) {
        return select == CONFIG.HINT_NUM;
    }

    private boolean hasSelectedToEat(int select) {
        return select == CONFIG.EAT_NUM;
    }

}
