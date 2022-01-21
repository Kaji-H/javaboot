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
    private int days;
    private List<FoodList> foodList = new ArrayList<>();

    public UnpopulatedIsland(Player player) {
        this.player = player;
        this.hint = new HintCountMng(GameConfig.HINT_NUM);
        this.choices = new Choices(Message.EAT, Message.NOT_EAT, Message.HINT);
        this.days = GameConfig.INIT_DAYS;
        this.foodList = initFoodList();
    }

    public void showPrologue() {

    }

    public void spend() {
        FoodList food = this.foodList.get(this.days - 1);

        showDay(this.days);
        showSituation(food, this.player.getHp());

        int select = 0;

        while (!doAction(select)) {

            showEatOrNot();
            select = selectPlayer();

            if (hasSelectedHint(select)) {

                hint.use();
                hint.pauseCounting();
                continue;
            }

            playEatAction(select, food);
        }

        if (this.player.isDeath()) {
            return;
        }

        this.days++;

        if (isClear(this.days)) {
            return;
        }

        hint.resumeCounting();

        spend();
        return;
    }

    private int selectPlayer() {
        String input = this.player.input();

        int num = Integer.parseInt(input);

        return num;
    }

    private void playEatAction(int select, FoodList food) {
    }

    private void showEatOrNot() {
        System.out.printf(Message.EAT_OR_NOT);

        int choicesNum = GameConfig.MAX_CHOICES;

        if (!hint.canUse()) {
            choicesNum--;
        }

        for (int i = GameConfig.MIN_CHOICES; i <= choicesNum; i++) {
            choices.showChoices(i);
        }

    }

    private void showDay(int day) {
        System.out.printf(Message.DATE, day);
    }

    private void showSituation(FoodList food, int hp) {
        System.out.printf(Message.FOOD_DATA,
                food.getName(),
                food.getAmountOfRexovery(),
                food.getDangerLevel());

        System.out.printf(Message.PLAYERS_HP, hp);
    }

    private boolean hasSelectedHint(int select) {
        return select == choices.getSelectNum(Message.HINT);
    }

    private boolean doAction(int select) {
        return select == choices.getSelectNum(Message.EAT) ||
                select == choices.getSelectNum(Message.NOT_EAT);
    }

    private boolean isClear(int day) {
        return day > GameConfig.MAX_DAYS;
    }

    public void showEnding() {
    }

    public void showLog() {
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

}
