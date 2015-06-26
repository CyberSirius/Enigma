package com.cybersirius;

import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Alphabet alphabet = new Alphabet();
        alphabet.setAlphabet("qwertyuiopasdfghjklzxcvbnm");
        Alphabet alphabet1 = new Alphabet();
        alphabet1.setAlphabet("qwertyuiopasdfghjklzxcvbnm");

        Alphabet alphabet2 = new Alphabet();
        alphabet2.setAlphabet("qwertyuiopasdfghjklzxcvbnm");
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
        Enigma enigma = new Enigma(reflector);
        Connector aTob = new Connector('a', 'b');
        enigma.addConnector(new Connector('c', 'd'));
        enigma.addConnector(new Connector('e', 'f'));
        enigma.addConnector(aTob);

        Rotor rotor = new Rotor(alphabet, 'K', 3);
        enigma.addRotor(rotor);

        Rotor rotor2 = new Rotor(alphabet1, 'F', 2);
        enigma.addRotor(rotor2);


        Rotor rotor3 = new Rotor(alphabet2, 'C', 1);
        enigma.addRotor(rotor3);

        enigma.initiate();
        System.out.println("Input: ");
        String input = in.nextLine();
        System.out.println("Output: ");
        String output = enigma.encode(input);
        System.out.println(output);
        enigma.initiate();
        System.out.println("Test: ");
        output = enigma.encode(output);
        System.out.println(output);
    }
}