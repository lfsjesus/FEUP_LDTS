package com.lfsjesus.lab6;

public class HumanClient implements Client {
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;
    private OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }
    private boolean happy = false;
    @Override
    public void happyHourStarted(Bar bar) {
        happy = true;
        strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        happy = false;
        strategy.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
        strategy.wants(drink, recipe, bar);
    }
}
