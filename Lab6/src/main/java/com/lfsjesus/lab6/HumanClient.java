package com.lfsjesus.lab6;

public class HumanClient implements Client {
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;
    private boolean happy = false;
    @Override
    public void happyHourStarted(Bar bar) {
        happy = true;
    }

    @Override
    public void happyHourEnded(Bar bar) {
        happy = false;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
    }
}
