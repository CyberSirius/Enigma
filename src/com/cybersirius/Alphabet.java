package com.cybersirius;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Strashimir on 21-Jun-15.
 Alphabet class, used in Rotor
 */
class Alphabet {
    public static final int ALPHABET_LENGTH = 26;
    private ArrayList<Character> alphabet = new ArrayList<>();

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

    public boolean isAlphabetCorrect() {
        boolean isCorrect = true;
        ArrayList<Character> sortedAlphabet = this.alphabet;
        Collections.sort(sortedAlphabet);
        for (int i = 0; i < sortedAlphabet.size() - 1; i++) {
            if (sortedAlphabet.get(i) == sortedAlphabet.get(i + 1)) {
                isCorrect = false;
            }
        }
        if (this.alphabet.size() != ALPHABET_LENGTH || !isCorrect) {
            isCorrect = false;
        }
        return isCorrect;
    }
}