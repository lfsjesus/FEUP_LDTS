package com.lfsjesus.lab6;

public interface Client extends BarObserver {
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
}
