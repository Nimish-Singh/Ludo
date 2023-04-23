package model;

import java.util.List;
import java.util.Random;

import static model.Token.STARTING_POSITION;

public class Board {
    private List<Player> players;
    private Die die;
    private final Integer NUMBER_OF_CELLS = 57;

    public Board(List<Player> players, Die die) {
        this.players = players;
        this.die = die;
    }

    public void playGame() {
        while (true) {
            for (Player activePlayer : players) {
                playTurn(activePlayer);
            }
        }
    }


    void playTurn(Player activePlayer) {
        int dieRoll = die.roll();

        List<Token> playerTokens = activePlayer.getTokens();
        Token activeToken = playerTokens.get(new Random().nextInt(0, playerTokens.size())); // Instead, take input from user

        if (activeToken.getPosition().equals(STARTING_POSITION)) {
            activeToken.move(1);
        }


        if (activeToken.getPosition() + dieRoll > NUMBER_OF_CELLS) {
            return;
        }

        activeToken.move(dieRoll);

        if (activeToken.getPosition().equals(NUMBER_OF_CELLS)) {
            activePlayer.remove(activeToken);
            if (activePlayer.hasWon()) {
                System.out.println(activePlayer.getName() + " has won!");
                System.exit(0);
            }
        }

        for (Player player : players) {
            for (Token token : player.getTokens()) {
                if (!player.equals(activePlayer) && token.getPosition().equals(activeToken.getPosition())) {
                    token.move(-(token.getPosition() + 1));
                    playTurn(activePlayer);
                }
            }
        }
    }
}
