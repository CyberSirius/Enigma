package com.cybersirius;

import java.util.ArrayList;
import java.util.Collections;

public class Enigma {
    private ArrayList<Connector> connectors = new ArrayList<Connector>();
    private ArrayList<Rotor> rotors = new ArrayList<Rotor>();
    private Reflector reflector = new Reflector();

    public Enigma(Reflector reflector) {
        this.reflector = reflector;
    }

    public Enigma(ArrayList<Connector> connectors, ArrayList<Rotor> rotors) {
        this.connectors = connectors;
        this.rotors = rotors;
    }

    public Enigma(ArrayList<Connector> connectors) {
        this.connectors = connectors;
    }

    public Enigma() {
    }

    protected Character switchLetter(char letter) {
        letter = Character.toLowerCase(letter);
        for (Connector connector : connectors) {

            if (letter == connector.getInputCharacter())
                return connector.getOutputCharacter();
            else if (letter == connector.getOutputCharacter())
                return connector.getInputCharacter();
        }
        return letter;
    }

    public void addConnector(Connector connector) {
        connectors.add(connector);
    }

    public void addRotor(Rotor rotor) {
        rotors.add(rotor);
    }

    public void initiate() {
        Collections.sort(rotors);
        for (Rotor rotor : rotors) {
            rotor.setUp();
        }
    }

    public String rotateLetters(String input, Rotor rotor, boolean isEncoding) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++)
            if (isEncoding)
                output.append(rotor.encodeLetter(input.charAt(i)));
            else {
                output.append(rotor.decodeLetter(input.charAt(i)));
            }
        return output.toString();
    }

    public char reflectLetter(char input) {
        return reflector.reflect(input);

    }

    public String switchLetters(String input) {
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
            for (int j = 0; j < rotors.size(); j++) {
                letter = rotors.get(j).encodeLetter(letter);
            }
            letter = reflectLetter(letter);
            for (int k = rotors.size() - 1; k >= 0; k--) {
                letter = rotors.get(k).decodeLetter(letter);
                if (i % Math.pow(((double) 26), ((double) k)) == 0) {
                    if (i == 0) {
                        if (k == 0) {
                            rotors.get(0).rotateOnce();
                        } else {
                        }
                    } else
                        rotors.get(k).rotateOnce();
                }
            }
            output.append(letter);
        }
        return switchLetters(output.toString());
    }
}