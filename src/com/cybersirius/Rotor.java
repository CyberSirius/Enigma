package com.cybersirius;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Strashimir on 21-Jun-15.
 * Rotor class
 */
class Rotor implements Comparable, Serializable {
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
        this.reset();
        int numOfRotations = ((int) Character.toUpperCase(this.startingLetter)) - 65;
        this.rotate(numOfRotations);
    }

    private void reset() {
        int rotate = alphabet.getIndex(initialLetter);
        if (rotate != 0) {
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

    public void save() {
        try {

            FileOutputStream fout = new FileOutputStream(this.startingLetter + this.position + ".ser");//dunno what I'm doing :D
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int compareTo(Object compareRotor) {
        int comparePosition = ((Rotor) compareRotor).getPosition();
        return this.position - comparePosition;
    }
}