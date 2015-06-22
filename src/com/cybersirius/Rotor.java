package com.cybersirius;

/**
 * Created by Strashimir on 21-Jun-15.
 */
public class Rotor {
    private char startingLetter;
    private Alphabet alphabet = new Alphabet();
    private boolean hasRotated;
    private int numOfRotations = 0;

    public Rotor() {
    }

    public Rotor(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public Rotor(char startingLetter, Alphabet alphabet, int position) {
        this.startingLetter = startingLetter;
        this.alphabet = alphabet;
        int position1 = position;
    }

    public Character encodeLetter(Character letter) {
        letter = Character.toUpperCase(letter);
        int numLetter = ((int) letter) - 65;
        return alphabet.getLetter(numLetter);
    }

    public void rotate(int numOfRotations) {
        for (int i = 0; i < numOfRotations; i++) {
            alphabet.rotateAlphabet();
        }
    }

    public void setUp() {
        int numOfRotations = ((int) startingLetter) - 65;
    }

    public void rotateOnce() {
        rotate(1);
        numOfRotations++;
        if (numOfRotations % alphabet.getSize() == 0)
            hasRotated = true;
    }

    public boolean hasRotated() {
        return hasRotated;
    }
    public Character decodeLetter(Character letter) {
        int numLetter = alphabet.getIndex(letter);
        return ((char) (numLetter + 97));
    }
}
