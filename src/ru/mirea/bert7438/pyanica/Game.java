package ru.mirea.bert7438.pyanica;


public interface Game {
    //int turns = 0;

    void initHands() throws Exception;
    void printHands();
    void turn();

}
