package ru.mirea.bert7438.pyanica;

import java.util.Stack;

public class Game {
    public static void stackGame(){
        Stack<Card> hand1 = new Stack<Card>();
        //fill each hand with cards
        for (int i = 0; i < 5; i++)
            hand1.push(new Card());
    }
}
