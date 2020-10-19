package ru.mirea.bert7438.pyanica;

public class Card implements Comparable<Card>{
    private final byte value;

    public Card(byte value) throws Exception {
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
        this.value = (byte) (Math.random()*9);
    }

    @Override
    public int compareTo(Card o) {
        if(this.value == 0){
            if (o.value == 9) return 1;
        }
        else if (this.value == 9){
            if (o.value == 0) return -1;
        }
        return Byte.compare(this.value, o.value);
    }
}
