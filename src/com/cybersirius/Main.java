package com.cybersirius;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
//        // write your code here
        Scanner in = new Scanner(System.in);
        Alphabet alphabet = new Alphabet();
        alphabet.setAlphabet("qwertyuiopasdfghjklzxcvbnm");

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
        reflector.addConnector(new Connector('r', 'q'));
        reflector.addConnector(new Connector('s', 'v'));
        reflector.addConnector(new Connector('t', 'z'));
        reflector.addConnector(new Connector('u', 'x'));


        Enigma enigma = new Enigma(reflector);
        Connector aTob = new Connector('a', 'b');
        enigma.addConnector(new Connector('c', 'd'));
        enigma.addConnector(new Connector('e', 'f'));
        enigma.addConnector(aTob);

        Rotor rotor = new Rotor(alphabet);
        enigma.addRotor(rotor);

        Rotor rotor2 = new Rotor(alphabet);
        enigma.addRotor(rotor2);

        Rotor rotor3 = new Rotor(alphabet);
        enigma.addRotor(rotor3);

        System.out.println("Input: ");
        String input = in.nextLine();
        System.out.println("Output: ");
        System.out.print(enigma.encode(input));
    }
}
