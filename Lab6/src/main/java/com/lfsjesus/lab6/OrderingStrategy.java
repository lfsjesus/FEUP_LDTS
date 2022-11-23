package com.lfsjesus.lab6;

public interface OrderingStrategy {
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
    void happyHourStarted(StringBar bar);
    void happyHourEnded(StringBar bar);
}
