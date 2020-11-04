package ru.mirea.bert7438.pyanica;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class DequeGame implements Game{
    private int turns;
    private ArrayDeque<Card> hand1;
    private ArrayDeque<Card> hand2;
    private boolean gameOver;
    Scanner sc = new Scanner(System.in);

    @Override
    public void initHands() throws Exception {
        turns = 0;
        System.out.println("Enter 1 Player's hand");
        hand1 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            int v = sc.nextInt();
            hand1.add(new Card(v));
        }
        System.out.println("Enter 2 Player's hand");
        hand2 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            int v = sc.nextInt();
            hand2.add(new Card(v));
        }
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
        Card c1 = hand1.poll();
        Card c2 = hand2.poll();
        if(c1.compareTo(c2) > 0){
            hand1.add(c1);
            hand1.add(c2);
        }
        else{
            hand2.add(c2);
            hand2.add(c1);
        }
        isOver();
    }

    private void isOver() {
        if(hand1.isEmpty()) {
            System.out.println("second");
            gameOver = true;
        }
        else if (hand2.isEmpty()){
            System.out.println("first");
            gameOver = true;
        }
        else if(turns == 106){
            System.out.println("botva");
            gameOver = true;
        }
    }

    public DequeGame() throws Exception {
        this.initHands();
        while(!gameOver) turn();
        System.out.println(this.turns);
    }
}
