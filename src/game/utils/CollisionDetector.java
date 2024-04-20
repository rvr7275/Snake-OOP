package game.utils;

import game.LoggerSetup;
import game.core.Food;
import game.core.Snake;
import java.awt.Point;
import java.util.List;
import java.util.logging.Logger;

// Class that detects collisions with walls, food, or the snake itself //

public class CollisionDetector {
    private static final Logger LOGGER = LoggerSetup.getLogger(CollisionDetector.class.getName());
    private final Snake snake;
    private final Food food;

    /**
     * Constructor to check for any collisions in the game's state
     * @throws IllegalArgumentException for if snake or food is null
     */

    public CollisionDetector(Snake snake, Food food) {
        if (snake == null || food == null) {
            throw new IllegalArgumentException();
        }
        this.snake = snake;
        this.food = food;
    }

    /**
     * Checks for collision with wall
     */
    public boolean wallCollision() {
        Point head = snake.getSnake().get(0);
        if (head.x < 0 || head.x >= Constants.NUM_COLS || head.y < 0 || head.y >= Constants.NUM_ROWS) {
            LOGGER.fine("Collision with wall.");
            return true;
        }
        return false;
    }

    /**
     * Checks for collision with food
     */
    public boolean foodCollision() {
        Point head = snake.getSnake().get(0);
        if (head.equals(food.getPosition())) {
            LOGGER.fine("Collision with food.");
            return true;
        }
        return false;
    }

    /**
     * Checks if the snake collides with its body
     */
    public boolean bodyCollision() {
        List<Point> snakeBody = snake.getSnake();
        Point head = snakeBody.get(0);
        for (int i = 1; i < snakeBody.size(); i++) {
            if (head.equals(snakeBody.get(i))) {
                LOGGER.fine("Collision onto snake body.");
                return true;
            }
        }
        return false;
    }
}
