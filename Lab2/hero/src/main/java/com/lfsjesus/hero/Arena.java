package com.lfsjesus.hero;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;

public class Arena {
    private Hero hero;
    private int width;
    private int height;
    public Arena (int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero (width / 2, height / 2);
    }

    public Hero getHero() {
        return hero;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private void moveHero (Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch(key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }

    public boolean canHeroMove(Position position) {
        if (position.getX() > width - 1 || position.getX() < 0 || position.getY() > height - 1 || position.getY() < 0) return false;
        return true;
    }
    

}
