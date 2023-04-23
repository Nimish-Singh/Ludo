import model.Board;
import model.Die;
import model.Player;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        Player red = new Player("red");
        Player blue = new Player("blue");
        Player green = new Player("green");
        Player yellow = new Player("yellow");

        Die die = new Die();
        Board board = new Board(List.of(red, blue, green, yellow), die);
        board.playGame();
    }
}
