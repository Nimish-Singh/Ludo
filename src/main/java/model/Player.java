package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int NUMBER_OF_TOKENS = 4;

    private String name;
    private List<Token> tokens;
    private int tokensReachedHome;


    public Player(String name) {
        this.name = name;
        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        Token token4 = new Token();

        this.tokens = new ArrayList<>();
        this.tokens.add(token1);
        this.tokens.add(token2);
        this.tokens.add(token3);
        this.tokens.add(token4);
    }

    void remove(Token token) {
        tokens.remove(token);
        tokensReachedHome++;
    }

    boolean hasWon() {
        return tokensReachedHome == NUMBER_OF_TOKENS;
    }

    public String getName() {
        return name;
    }

    public List<Token> getTokens() {
        return new ArrayList<>(tokens);
    }
}
