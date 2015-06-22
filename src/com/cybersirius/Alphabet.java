package com.cybersirius;

import java.util.ArrayList;

/**
 * Created by Strashimir on 21-Jun-15.
 */
public class Alphabet {
    private ArrayList<Character> alphabet = new ArrayList<Character>();

    public Alphabet() {
    }

    public Alphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public void setAlphabet(String input) {
        for (int i = 0; i < input.length(); i++) alphabet.add(input.toLowerCase().charAt(i));
    }

    public void rotateAlphabet() {
        Character a, b;
        a = alphabet.get(0);
        b = alphabet.get(1);
        for (int i = 1; i < alphabet.size(); i++) {
            alphabet.set(i, a);
            a = b;
            if (i + 1 == alphabet.size())
                alphabet.set(0, a);
            else
                b = alphabet.get(i + 1);
        }
    }

    public void printAlphabet() {
        for (Character character : alphabet) {
            System.out.print(character);
        }
    }
}