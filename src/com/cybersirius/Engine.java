package com.cybersirius;

import java.util.ArrayList;

public class Engine {
    private ArrayList<Connector> connectors = new ArrayList<Connector>();
    private ArrayList<Rotor> rotors = new ArrayList<Rotor>();
    private Reflector reflector = new Reflector();

    public Engine(Reflector reflector) {
        this.reflector = reflector;
    }

    public Engine(ArrayList<Connector> connectors, ArrayList<Rotor> rotors) {
        this.connectors = connectors;
        this.rotors = rotors;
    }

    public Engine(ArrayList<Connector> connectors) {
        this.connectors = connectors;
    }

    public Engine() {
    }

    protected Character switchLetter(char letter, boolean isEncoding) {
        letter = Character.toLowerCase(letter);
        for (Connector connector : connectors) {
            if (isEncoding) {
                if (letter == connector.getInputCharacter())
                    return connector.getOutputCharacter();
            } else {
                if (letter == connector.getOutputCharacter())
                    return connector.getInputCharacter();

            }

        }
        return letter;
    }

    public void addConnector(Connector connector) {
        connectors.add(connector);
    }

    public void addRotor(Rotor rotor) {
        rotors.add(rotor);
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

    public String reflectLetters(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(reflector.reflect(input.charAt(i)));

        }
        return output.toString();
    }

    public String switchLetters(String input, boolean isEncoding) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(switchLetter(input.charAt(i), isEncoding));
        }
        return output.toString();
    }

    public String encode(String input) {
        String output;
        boolean isIn = true;
        output = switchLetters(input, isIn);

        return output;
    }
}