package game.utils;

import game.LoggerSetup;
import game.core.Food;
import game.core.Snake;
import java.awt.Point;
import java.util.List;
import java.util.logging.Logger;

/**
 * A helper class used to check if the {@code snake} has collided with anything within the current frame.
 */
public class CollisionDetector {
    /**
     * Logger for logging information.
     */
    private static final Logger LOGGER = LoggerSetup.getLogger(CollisionDetector.class.getName());

    /**
     * A reference to the {@code Snake} object of the current game loop.
     */
    private final Snake snake;

    /**
     * A reference to the {@code Food} object of the current game loop.
     */
    private final Food food;

    /**
     * Initializes a new {@code CollisionDetector} object storing instances of the current game loop's
     * snake and food objects.
     * @param snake current snake object
     * @param food current food object
     * @throws IllegalArgumentException if {@code snake} or {@code food} is null.
     */
    public CollisionDetector(Snake snake, Food food) {
        if (snake == null || food == null) {
            throw new IllegalArgumentException("Snake and food can't' be null.");
        }
        this.snake = snake;
        this.food = food;
    }

    /**
     * Checks if the {@code snake} has collided with the wall within the current frame. If the snake's head has exited
     * the bounds of the grid then it has collided with the wall.
     * @return true if the {@code snake} has collided with the wall, false otherwise.
     */
    public boolean checkWallCollision() {
        Point head = snake.getSnake().get(0);
        return head.x < 0 || head.x >= Constants.WIDTH || head.y < 0 || head.y >= Constants.HEIGHT;
    }

    /**
     * Checks if the {@code snake} has collided with the {@code food} object within the current frame. If the head and
     * food share the same position then they have collided.
     * @return true if the {@code snake} has collided with the {@code food}, false otherwise.
     */
    public boolean checkFoodCollision() {
        Point head = snake.getSnake().get(0);
        return head.equals(food.getPosition()); // Assuming Food has a getPosition method returning a Point
    }

    /**
     * Checks if the {@code snake} has collided with itself within the current frame. If the head shares a position
     * with any other part of its body other than the head, then it has collided with itself.
     * @return true if {@code snake} has collided with itself, false otherwise.
     */
    public boolean checkSelfCollision() {
        List<Point> body = snake.getSnake();
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }
}
