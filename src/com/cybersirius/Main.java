package com.cybersirius;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        String input = in.nextLine();
        Engine engine = new Engine();
        Connector aTob = new Connector('a', 'b');
        engine.addConnector(new Connector('b', 'c'));
        engine.addConnector(new Connector('c', 'd'));
        engine.addConnector(new Connector('d', 'e'));
        engine.addConnector(aTob);
        System.out.println("Output");
        System.out.println(engine.switchLetters(input));
    }
}
