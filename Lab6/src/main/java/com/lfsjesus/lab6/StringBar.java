package com.lfsjesus.lab6;

import java.util.List;

public class StringBar extends Bar{
    private boolean happy = false;

    public StringBar() {

    }
    public StringBar(List<BarObserver> observers) {
        super(observers);
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
