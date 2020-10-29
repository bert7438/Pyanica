package ru.mirea.bert7438.pyanica;

import java.util.Scanner;
import java.util.Stack;

public class StackGame implements Game{
    private Stack<Card> hand11, hand12;
    private Stack<Card> hand21, hand22;
    private int turns = 0;
    private boolean gameOver = false;
    Scanner sc = new Scanner(System.in);

    @Override
    public void initHands() throws Exception {
        System.out.println("Enter Player 1's hand");
        hand11 = new Stack<Card>();
        hand12 = new Stack<Card>();
        for (int i = 0; i < 5; i++){
            int v = sc.nextInt();
            hand11.push(new Card(v));
            hand12.push(hand11.pop());
        }

        System.out.println("Enter Player 2's hand");
        hand21 = new Stack<Card>();
        hand22 = new Stack<Card>();
        for (int i = 0; i < 5; i++){
            int v = sc.nextInt();
            hand21.push(new Card(v));
            hand22.push(hand21.pop());
        }
    }

    @Override
    public void printHands() {
        System.out.println("Player 1's hand:");
        for(Card i: hand12)
            System.out.println(i);

        System.out.println("Player 2's hand:");
        for(Card i: hand22)
            System.out.println(i);
    }

    @Override
    public void turn() {
        turns++;
        Card c1 = hand12.pop();
        Card c2 = hand22.pop();
        if(c1.compareTo(c2) > 0){
            while (!hand12.isEmpty())
                hand11.push(hand12.pop());
            hand12.push(c2);
            hand12.push(c1);
            while (!hand11.isEmpty())
                hand12.push(hand11.pop());
        }
        else {
            while(!hand22.isEmpty())
                hand21.push(hand22.pop());
            hand22.push(c1);
            hand22.push(c2);
            while(!hand21.isEmpty())
                hand22.push(hand21.pop());
        }
        isOver();
    }

    private void isOver(){
        if(hand12.isEmpty()) {
            System.out.println("second");
            gameOver = true;
        }
        else if (hand22.isEmpty()){
            System.out.println("first");
            gameOver = true;
        }
        else if(turns == 106){
            System.out.println("botva");
            gameOver = true;
        }
    }

    public StackGame() throws Exception {
        this.initHands();
        while(!gameOver) turn();
        System.out.println(this.turns);
    }
}
