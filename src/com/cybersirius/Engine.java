package com.cybersirius;

import java.util.ArrayList;

public class Engine {
    private ArrayList<Connector> connectors = new ArrayList<Connector>();

    public Engine(ArrayList<Connector> connectors) {
        this.connectors = connectors;
    }

    public Engine() {
    }

    public Character switchLetter(char letter) {
        for (Connector connector : connectors) {
            if (letter == connector.getInputCharacter())
                return connector.getOutputCharacter();
        }
        return letter;
    }

    public void addConnector(Connector connector) {
        connectors.add(connector);
    }

    public String switchLetters(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(switchLetter(input.charAt(i)));
        }
        return output.toString();
    }
}