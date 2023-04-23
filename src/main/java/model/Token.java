package model;

public class Token {
    public static final int STARTING_POSITION = -1;
    private Integer position;

    Token() {
        position = STARTING_POSITION;
    }

    void move(int steps) {
        position += steps;
    }

    public Integer getPosition() {
        return position;
    }
}
