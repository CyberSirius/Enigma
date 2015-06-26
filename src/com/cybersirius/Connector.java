package com.cybersirius;

/**
 * Created by Strashimir on 21-Jun-15.
 Connector class

 */
class Connector {
    private final char inputCharacter;
    private final char outputCharacter;

    public Connector(char inputCharacter, char outputCharacter) {
        this.inputCharacter = inputCharacter;
        this.outputCharacter = outputCharacter;
    }

    public char getInputCharacter() {
        return inputCharacter;
    }

    public char getOutputCharacter() {
        return outputCharacter;
    }
}
