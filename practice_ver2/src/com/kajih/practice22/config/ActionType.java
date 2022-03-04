package com.kajih.practice22.config;

public enum ActionType {
    CATCH(1, "捕まえる"),
    RELEASE(2, "逃がす");

    private int id;
    private String actionName;

    ActionType(int id, String actionName) {
        this.id = id;
        this.actionName = actionName;
    }

    public int getId() {
        return this.id;
    }

    public String getActionName() {
        return this.actionName;
    }
}
