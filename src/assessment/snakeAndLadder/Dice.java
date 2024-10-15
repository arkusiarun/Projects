package assessment.snakeAndLadder;

import java.util.Random;

class Dice {
    private final Random random;

    public Dice() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}