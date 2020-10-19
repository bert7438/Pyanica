package ru.mirea.bert7438.pyanica;

import java.util.Scanner;
import java.util.Stack;

public class StackGame implements Game{
    private Stack<Card> hand1;
    private Stack<Card> hand2;
    private int turns = 0;
    Scanner sc = new Scanner(System.in);

    @Override
    public void initHands() throws Exception {
        System.out.println("Enter Player 1's hand");
        hand1 = new Stack<Card>();
        for (int i = 0; i < 5; i++){
            byte v = sc.nextByte();
            hand1.push(new Card(v));
        }

        System.out.println("Enter Player 2's hand");
        hand2 = new Stack<Card>();
        for (int i = 0; i < 5; i++){
            byte v = sc.nextByte();
            hand2.push(new Card(v));
        }
    //TODO: WTF how to deal with deque via stack?!
    }

    @Override
    public void printHands() {
        System.out.println("Player 1's hand:");
        for(Card i: hand1)
            System.out.println(i);

        System.out.println("Player 2's hand:");
        for(Card i: hand2)
            System.out.println(i);
    }

    @Override
    public void turn() {
        turns++;

    }
}
