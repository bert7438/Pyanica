package ru.mirea.bert7438.pyanica;

public class Card implements Comparable<Card>{
    private final int value;

    public Card(int value) throws Exception {
        if (value >= 0 && value<=9)
            this.value = value;
        else throw new Exception("Card must have value from 0 to 9");
    }

    @Override
    public String toString() {
        return "Card{" +
                 value +
                '}';
    }

    public Card(){
        this.value = (int) (Math.random()*9);
    }

    @Override
    public int compareTo(Card o) {
        if(this.value == 0){
            if (o.value == 9) return 1;
        }
        else if (this.value == 9){
            if (o.value == 0) return -1;
        }
        return Integer.compare(this.value, o.value);
    }
}
