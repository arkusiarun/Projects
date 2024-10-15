package assessment.snakeAndLadder;

import java.util.List;

class Board {
    private final int size;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int checkSnakeOrLadder(int position) {
        for (Snake snake : snakes) {
            if (snake.getStart() == position) {
                System.out.println("Player bitten by a snake! Goes down from " + snake.getStart() + " to " + snake.getEnd());
                return snake.getEnd();
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                System.out.println("Player climbs a ladder! Goes up from " + ladder.getStart() + " to " + ladder.getEnd());
                return ladder.getEnd();
            }
        }
        return position;
    }
}