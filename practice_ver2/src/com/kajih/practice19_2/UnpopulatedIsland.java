package com.kajih.practice19_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kajih.practice19_2.Config.GameConfig;
import com.kajih.practice19_2.Config.Message;

public class UnpopulatedIsland {

    private Random RAND = new Random();

    private Player player;
    private HintCountMng hint;
    private Choices choices;
    private Log log;
    private int days;
    private List<FoodList> foodList = new ArrayList<>();

    public UnpopulatedIsland(Player player) {
        this.player = player;
        this.hint = new HintCountMng(GameConfig.HINT_NUM);
        this.choices = new Choices(Message.EAT, Message.NOT_EAT, Message.HINT);
        this.log = new Log();
        this.days = GameConfig.INIT_DAYS;
        this.foodList = initFoodList();
    }

    public void showPrologue() {
        System.out.printf(Message.PROLOGUE, GameConfig.MAX_DAYS);
    }

    public void spend() {
        FoodList food = this.foodList.get(this.days - 1);

        showDay(this.days);
        showSituation(food, this.player.getHp());

        int select = 0;

        while (!doAction(select)) {

            showEatOrNotQuestionAndChoices();
            select = selectPlayer();

            if (hasSelectedHint(select)) {
                FoodList nextFood = this.foodList.get(this.days);
                showNextFoodData(nextFood);

                this.hint.use();
                this.hint.pauseCounting();
                continue;
            }

            this.log.setRecordOfDay(this.days,
                    this.player.getHp(),
                    food.getName(),
                    food.getDangerLevel(),
                    this.choices.getChoiceName(select));
            playEatAction(select, food);
        }

        if (isEscapeIslandOrDie()) {
            return;
        }

        this.days++;
        this.hint.resumeCounting();

        spend();
        return;
    }

    public void showEnding() {
        if (player.isDeath()) {
            System.out.println(player.getCauseOfDeath());
            return;
        }

        System.out.printf(Message.ENDING, GameConfig.MAX_DAYS);
    }

    public void showLog() {
        this.log.show();
    }

    private List<FoodList> initFoodList() {
        List<FoodList> list = new ArrayList<>();

        for (int i = 0; i < GameConfig.MAX_DAYS; i++) {
            int foodId = RAND.nextInt(FoodList.values().length);
            list.add(FoodList.toEnum(foodId));

            System.out.println(list.get(i).getName());
        }
        return list;
    }

    private int selectPlayer() {
        String input = this.player.input();

        int num = validate(input);

        return num;
    }

    private int validate(String input) {
        if (!isNum(input)) {
            showWarningToInputNonNumeric();
            return selectPlayer();
        }

        int num = Integer.parseInt(input);

        if (!isChoicesRange(num)) {
            showWarningToInputOutOfChoices();
            return selectPlayer();
        }
        return num;
    }

    private void playEatAction(int select, FoodList food) {
        if (hasSelectedNotEat(select)) {
            player.decreseHpWhenHungry();
            return;
        }

        if (this.player.canEat(food.getDangerLevel())) {
            this.player.recoverHp(food.getAmountOfRexovery());
            return;
        }

        this.player.sufferFromFoodPoisoning(food.getCauseOfDeath());
        return;
    }

    private void showEatOrNotQuestionAndChoices() {
        System.out.printf(Message.EAT_OR_NOT);

        int choicesNum = calChoicesNum();

        for (int i = GameConfig.MIN_CHOICES; i <= choicesNum; i++) {
            choices.showChoices(i);
        }

        System.out.printf(Message.NEWLINE);
    }

    private int calChoicesNum() {
        int num = choices.getChoicesLength();

        if (!hint.canUse()) {
            num--;
        }

        return num;
    }

    private void showDay(int day) {
        System.out.printf(Message.DATE, day);
    }

    private void showSituation(FoodList food, int hp) {
        showFoodData(food);

        System.out.printf(Message.PLAYERS_HP, hp);
    }

    private void showFoodData(FoodList food) {
        System.out.printf(Message.FOOD_DATA,
                food.getName(),
                food.getAmountOfRexovery(),
                food.getDangerLevel());
    }

    private void showNextFoodData(FoodList food) {
        System.out.printf(Message.TOMMOROW_FOOD);

        showFoodData(food);

        System.out.printf(Message.NEWLINE);
    }

    private void showWarningToInputNonNumeric() {
        System.out.printf(Message.WARREING_TO_INPUT_NON_NUMERIC);
    }

    private void showWarningToInputOutOfChoices() {
        System.out.printf(Message.WARRNING_TO_INPUT_OUT_OF_CHOICES);
    }

    private boolean hasSelectedHint(int select) {
        return select == choices.getSelectNum(Message.HINT);
    }

    private boolean hasSelectedNotEat(int select) {
        return select == choices.getSelectNum(Message.NOT_EAT);
    }

    private boolean doAction(int select) {
        return select == choices.getSelectNum(Message.EAT) ||
                select == choices.getSelectNum(Message.NOT_EAT);
    }

    private boolean isClear(int day) {
        return day >= GameConfig.MAX_DAYS;
    }

    private boolean isNum(String select) {
        try {
            Integer.parseInt(select);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isChoicesRange(int num) {
        int maxChoices = calChoicesNum();

        return num <= maxChoices && num >= GameConfig.MIN_CHOICES;
    }

    private boolean isEscapeIslandOrDie() {
        return this.player.isDeath() || isClear(this.days);
    }

}
