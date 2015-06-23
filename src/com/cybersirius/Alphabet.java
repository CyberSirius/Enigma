package com.cybersirius;

import java.util.ArrayList;

/**
 * Created by Strashimir on 21-Jun-15.
 */
public class Alphabet {
    private ArrayList<Character> alphabet = new ArrayList<Character>();

    public Alphabet(Alphabet alphabet) {
        this.alphabet = alphabet.getAlphabet();
    }

    public Alphabet() {
    }

    public Alphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String input) {
        for (int i = 0; i < input.length(); i++) alphabet.add(input.toLowerCase().charAt(i));
    }

    public void rotateAlphabet() {
        Character a, b;
        a = this.alphabet.get(0);
        b = this.alphabet.get(1);
        for (int i = 1; i < this.alphabet.size(); i++) {
            this.alphabet.set(i, a);
            a = b;
            if (i + 1 == this.alphabet.size())
                this.alphabet.set(0, a);
            else
                b = this.alphabet.get(i + 1);
        }
    }

    public void printAlphabet() {
        for (Character character : this.alphabet) {
            System.out.print(character);
        }
    }

    public Character getLetter(int index) {
        return this.alphabet.get(index);
    }

    public int getSize() {
        return this.alphabet.size();
    }

    public int getIndex(Character letter) {
        letter = Character.toLowerCase(letter);
        return this.alphabet.indexOf(letter);
    }
}