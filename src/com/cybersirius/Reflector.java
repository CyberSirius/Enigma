package com.cybersirius;

import java.util.ArrayList;

/**
 * Created by Strashimir on 22-Jun-15.
 */
public class Reflector {
    private ArrayList<Connector> alphabet = new ArrayList<Connector>();

    public Reflector() {
    }

    public Reflector(ArrayList<Connector> alphabet) {
        this.alphabet = alphabet;
    }

    public Character reflect(Character letter) {
        for (Connector connector : alphabet) {
            if (connector.getInputCharacter() == letter)
                return connector.getOutputCharacter();
            else if (connector.getOutputCharacter() == letter)
                return connector.getInputCharacter();
        }
        return letter;
    }

    public void addConnector(Connector connector) {
        alphabet.add(connector);
    }
}