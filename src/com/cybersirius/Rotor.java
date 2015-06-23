package com.cybersirius;

/**
 * Created by Strashimir on 21-Jun-15.
 */
class Rotor implements Comparable {
    private final char startingLetter;
    private final char initialLetter;
    private Alphabet alphabet = new Alphabet();
    private int position = 0;

    public Rotor(Alphabet alphabet, char startingLetter, int position) {
        this.startingLetter = startingLetter;
        this.alphabet = alphabet;
        this.position = position;
        this.initialLetter = alphabet.getLetter(0);
    }

    private int getPosition() {
        return position;
    }

    public Character encodeLetter(Character letter) {
        letter = Character.toUpperCase(letter);
        int numLetter = ((int) letter) - 65;
        return alphabet.getLetter(numLetter);
    }

    private void rotate(int numOfRotations) {
        for (int i = 0; i < numOfRotations; i++) {
            alphabet.rotateAlphabet();
        }
    }

    public void setUp() {
        reset();
        int numOfRotations = ((int) Character.toUpperCase(startingLetter)) - 65;
        rotate(numOfRotations);
    }

    private void reset() {
        int rotate = 26 - alphabet.getIndex(initialLetter);
        if (rotate != 26) {
            rotate(rotate);
        }
    }

    public void rotateOnce() {
        rotate(1);
    }

    public Character decodeLetter(Character letter) {
        int numLetter = alphabet.getIndex(letter);
        return ((char) (numLetter + 97));
    }

    @Override
    public int compareTo(Object compareRotor) {
        int comparePosition = ((Rotor) compareRotor).getPosition();
        return comparePosition - this.position;
    }
}
