package com.cybersirius;

import javafx.scene.control.TextField;

/**
 * Created by CyberSirius on 04-Nov-15.
 */
public class Controller {
    public TextField txtRotor1;
    public TextField txtRotor2;
    public TextField txtRotor3;
    private Enigma enigma;

    public Controller() {
        Reflector reflector = new Reflector();
        reflector.addConnector(new Connector('a', 'n'));
        reflector.addConnector(new Connector('b', 'p'));
        reflector.addConnector(new Connector('c', 'm'));
        reflector.addConnector(new Connector('d', 'i'));
        reflector.addConnector(new Connector('e', 'k'));
        reflector.addConnector(new Connector('f', 'g'));
        reflector.addConnector(new Connector('h', 'w'));
        reflector.addConnector(new Connector('j', 'o'));
        reflector.addConnector(new Connector('l', 'y'));
        reflector.addConnector(new Connector('u', 'x'));
        reflector.addConnector(new Connector('r', 'q'));
        reflector.addConnector(new Connector('s', 'v'));
        reflector.addConnector(new Connector('t', 'z'));
        this.enigma = new Enigma(reflector);
    }

    public void rotorSetUp() {
        Alphabet alphabet = new Alphabet();
        alphabet.setAlphabet(txtRotor1.getText());
        Alphabet alphabet1 = new Alphabet();
        alphabet1.setAlphabet(txtRotor2.getText());
        Alphabet alphabet2 = new Alphabet();
        alphabet2.setAlphabet(txtRotor3.getText());
        Rotor rotor = new Rotor(alphabet, 'K', 3);
        this.enigma.addRotor(rotor);
        Rotor rotor2 = new Rotor(alphabet1, 'F', 2);
        this.enigma.addRotor(rotor2);
        Rotor rotor3 = new Rotor(alphabet2, 'C', 1);
        this.enigma.addRotor(rotor3);
    }

    public void connectorsSetUp() {

    }
}
