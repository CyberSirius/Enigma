package com.cybersirius;

import java.util.ArrayList;

/**
 * Created by Strashimir on 21-Jun-15.
 Alphabet class, used in Rotor
 */
class Alphabet {
    //    todo implement isAlphabetCorrect(all symbols different, correct length, based on language)
    private ArrayList<Character> alphabet = new ArrayList<Character>();

    public Alphabet(Alphabet alphabet) {
        this.alphabet = alphabet.getAlphabet();
    }

    public Alphabet() {
    }

    public Alphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    private ArrayList<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String input) {
        for (int i = 0; i < input.length(); i++) alphabet.add(input.toLowerCase().charAt(i));
    }

    public void rotateAlphabet() {
        alphabet.add(alphabet.get(0));
        alphabet.remove(0);
    }

    public Character getLetter(int index) {
        return alphabet.get(index);
    }

    public int getIndex(Character letter) {
        letter = Character.toLowerCase(letter);
        return alphabet.indexOf(letter);
    }
}