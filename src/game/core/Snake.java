package game.core;

import game.LoggerSetup;
import game.utils.Constants;
import game.utils.Direction;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The {@code Snake} class is responsible for managing the current position of the {@code body} and {@code direction}
 * of the snake within the current game loop. It can only change directions once per frame so the {@code nextDirection}
 * is queued until the next frame begins. Inputs can be buffered (multiple entered per frame), allowing for the game
 * to feel more responsive.
 */
public class Snake {
    /**
     * Logger for logging information.
     * @hidden
     */
    private static final Logger LOGGER = LoggerSetup.getLogger(Snake.class.getName());

    /**
     * A List representing the points on the grid the snake's body occupies.
     */
    private final List<Point> body;

    /**
     * Used to determine which direction the snake is currently moving.
     */
    private Direction direction;

    /**
     * Used to determine which direction the snake will move on the next frame.
     */
    private Direction nextDirection;
    /**
     * Used to buffer an input for the next frame. Allows for two inputs to be used on the current frame. Is only set
     * if the direction is attempted to be changed while {@code nextDirection} is not {@code null}.
     */
    private Direction bufferDirection;
    /**
     * A {@code Point} used to represent the tail from the previous frame. This is added to the end of the snake when it
     * grows and when the snake moves backwards a frame when the game ends.
     */
    private Point oldTail;

    /**
     * Initializes a {@code snake} in a game ready state based on the values in the {@link Constants} class by creating
     * a list of points to represent the {@code body} and setting its starting direction.
     */
    Snake() {

    }

    /**
     * Moves the snack up one space based on the new direction of the snake. This method is called once a frame so the
     * direction must be updated as well.
     */
    public void move() {

    }

    /**
     * Increase the length of the snake by adding the tail from the previous frame to the {@code body}.
     */
    public void grow() {

    }

    /**
     * Changes the {@code nextDirection} of the snake if it is not attempting to go in the opposite direction, such as
     * right to left. If the {@code nextDirection} already has a value then buffer the input instead by setting
     * {@code bufferDirection} to the {@code newDirection}.
     * @param newDirection direction to attempt to change to.
     */
    public void changeDirection(Direction newDirection) {

    }

    /**
     * Sets the current {@code direction} to the {@code nextDirection }as long as the {@code nextDirection} is not null.
     * Uses the {@code bufferDirection} to set the value of {@code nextDirection} for the next frame.
     * Resets {@code bufferDirection} to {@code null}.
     */
    public void updateDirection() {

    }

    /**
     * Moves the snake backwards to its state from the previous frame. This is used when the snake dies
     * And we don't want to show the snake phased inside the wall on the final frame.
     */
    public void moveBackwards() {

    }

    /**
     * Gets the {@code List<Point>} representing the {@code body} of the snake.
     * @return a list representing the snake.
     */
    public List<Point> getSnake() {
        return body;
    }
}
