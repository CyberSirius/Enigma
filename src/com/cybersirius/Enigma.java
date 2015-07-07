package com.cybersirius;

import java.util.ArrayList;
import java.util.Collections;

class Enigma {
    public static final int ALPHABET_LENGTH = 26;
    private ArrayList<Connector> plugboard = new ArrayList<>();
    private ArrayList<Rotor> rotors = new ArrayList<>();
    private Reflector reflector = new Reflector();

    public Enigma(Reflector reflector) {
        this.reflector = reflector;
    }

    public Enigma(ArrayList<Connector> plugboard, ArrayList<Rotor> rotors) {
        this.plugboard = plugboard;
        this.rotors = rotors;
    }

    public Enigma(ArrayList<Connector> plugboard) {
        this.plugboard = plugboard;
    }

    public Enigma() {
    }

    private Character switchLetter(char letter) {
        letter = Character.toLowerCase(letter);
        for (Connector connector : plugboard) {

            if (letter == connector.getInputCharacter())
                return connector.getOutputCharacter();
            else if (letter == connector.getOutputCharacter())
                return connector.getInputCharacter();
        }
        return letter;
    }

    public void addConnector(Connector connector) {
        plugboard.add(connector);
    }

    public void addRotor(Rotor rotor) {
        rotors.add(rotor);
    }

    public void initiate() {
        Collections.sort(this.rotors);
        this.rotors.forEach((rotor) -> rotor.setUp());
    }

    private char reflectLetter(char input) {
        return reflector.reflect(input);

    }

    private String switchLetters(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(switchLetter(input.charAt(i)));
        }
        return output.toString();
    }

    public String encode(String input) {
        StringBuilder output = new StringBuilder();
        input = switchLetters(input);//iffy
        char letter;
        for (int i = 0; i < input.length(); i++) {
            letter = input.charAt(i);
            if (Character.isLetter(letter)) {
                for (Rotor rotor : rotors) {
                    letter = rotor.encodeLetter(letter);
                }
                letter = reflectLetter(letter);
                for (int k = rotors.size() - 1; k >= 0; k--) {
                    letter = rotors.get(k).decodeLetter(letter);
                    if (i % Math.pow(((double) ALPHABET_LENGTH), ((double) k)) == 0) {
                        if (i == 0) {
                            if (k == 0) {
                                rotors.get(0).rotateOnce();
                            } else {
                            }
                        } else
                            rotors.get(k).rotateOnce();
                    }
                }
            }

            output.append(letter);
        }
        return switchLetters(output.toString());
    }
}