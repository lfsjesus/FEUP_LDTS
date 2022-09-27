package com.lfsjesus.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Game {
   Game() {
       TerminalSize terminalSize = new TerminalSize(int column, int row);
       DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
       Terminal terminal = terminalFactory.createTerminal();
       Screen screen = new TerminalScreen(terminal);
       screen.setCursorPosition(null); // we don't need a cursor
       screen.startScreen(); // screens must be started
       screen.doResizeIfNecessary(); // resize screen if necessary
       screen.clear();
       screen.setCharacter(int column, int row, TextCharacter.fromCharacter('X')[0]);
       screen.refresh();
    }

}