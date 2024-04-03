package game.core;

import game.LoggerSetup;
import game.utils.Constants;

import java.awt.*;
import java.util.Random;
import java.util.logging.Logger;

/**
 * The {@code Food} class is responsible for managing the spawning and storing of the current food on the screen.
 */
public class Food {
    /**
     * Logger for logging information.
     * @hidden
     */
    private static final Logger LOGGER = LoggerSetup.getLogger(Food.class.getName());

    /**
     * Represents the current {@code position} of the {@code Food}.
     */
    private Point position;

    /**
     * Used to generate a random position for the food.
     */
    private final Random rand;
    /**
     * Holds a reference to the current snake object. Used to ensure food does not spawn inside the snake's body.
     */
    private final Snake snake;

    /**
     * Creates {@code Food} at a {@code Point} specified location.
     * @param initialPos The initial position of the food. Must not be {@code null} and must be within the grid's bounds.
     * @param snake A reference to the current snake object. Must not be {@code null}.
     * @throws IllegalArgumentException if {@code initialPos} is {@code null} or is outside the grid's range or if the
     *                                  {@code snake} is null.
     *                                  This exception is caught and logged at {@code Level.SEVERE}.
     */
    Food(Point initialPos, Snake snake) {

    }

    /**
     * Creates food at a random position. The food is spawned at a random point in the grid that is not currently
     * occupied by the snake.
     */
    public void spawn() {

    }

    /**
     * Gets the {@code Point} representing the {@code position} of the food.
     * @return The {@code Point} representing the current position.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Validates the values passed in to the food constructor
     *
     * @hidden
     * @param initialPos The initial position of the food.
     * @param snake A reference to the current snake object.
     * @throws IllegalArgumentException if {@code initialPos} is {@code null} or is outside the grid's range or if the
     *                                  {@code snake} is null.
     *                                  This exception is caught and logged at {@code Level.SEVERE}.
     */
    private void validateConstructor(Point initialPos, Snake snake) {

    }
}
