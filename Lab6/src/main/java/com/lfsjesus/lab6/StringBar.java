package com.lfsjesus.lab6;

import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    private boolean happy = false;

    public StringBar() {
        observers = new ArrayList<>();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
    @Override
    public boolean isHappyHour() {
        return happy;
    }

    @Override
    public void startHappyHour() {
        happy = true;
        notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happy = false;
        notifyObservers();
    }
}
