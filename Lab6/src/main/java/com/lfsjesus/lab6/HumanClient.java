package com.lfsjesus.lab6;

public class HumanClient implements Client {
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;
    private OrderingStrategy _strategy;

    private boolean happy = false;

    public HumanClient(OrderingStrategy strategy) {
        this._strategy = strategy;
    }

    @Override
    public void happyHourStarted(Bar bar) {
        happy = true;
        _strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        happy = false;
        _strategy.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
        _strategy.wants(drink, recipe, bar);
    }
}
