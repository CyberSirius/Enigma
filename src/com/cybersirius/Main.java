package com.cybersirius;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
//TODO Implementing a simple GUI is top priority

    public static void main(String[] args) {
        launch(args);
        Scanner in = new Scanner(System.in);
        //<editor-fold desc="Alphabets init">
        Alphabet alphabet = new Alphabet();
        alphabet.setAlphabet("qwertyuiopasdfghjklzxcvbnm");
        Alphabet alphabet1 = new Alphabet();
        alphabet1.setAlphabet("qwertyuiopasdfghjklzxcvbnm");
        Alphabet alphabet2 = new Alphabet();
        alphabet2.setAlphabet("qwertyuiopasdfghjklzxcvbnm");
        //</editor-fold>s
        //<editor-fold desc="Reflector init">
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
        //<editor-fold desc="Connector inits">
        Connector aTob = new Connector('a', 'b');
        enigma.addConnector(new Connector('c', 'd'));
        enigma.addConnector(new Connector('e', 'f'));
        enigma.addConnector(aTob);
        //</editor-fold>
        //<editor-fold desc="Rotors init">
        Rotor rotor = new Rotor(alphabet, 'K', 3);
        enigma.addRotor(rotor);
        Rotor rotor2 = new Rotor(alphabet1, 'F', 2);
        enigma.addRotor(rotor2);
        Rotor rotor3 = new Rotor(alphabet2, 'C', 1);
        enigma.addRotor(rotor3);
        //</editor-fold>
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }
}