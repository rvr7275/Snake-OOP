package game.core;

import game.LoggerSetup;
import game.utils.CollisionDetector;
import game.utils.Constants;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * The {@code GameEngine} is used to store instances of all major
 * components of the current game loop and manages the state of the game.
 */
public class GameEngine {
    /**
     * Logger for logging information.
     * @hidden
     */
    private static final Logger LOGGER = LoggerSetup.getLogger(GameEngine.class.getName());

    /** Specifies whether the game is currently running. */
    private boolean isRunning;

    /**
     * The {@code Snake} object of the current game loop. Its initial position is determined by the
     * {@link Constants#SNAKE_INITIAL_POSITION} from the {@code Constants} class.
     */
    private Snake snake;

    /**
     * The {@code Food} object of the current game loop. Its initial position is determined by the
     * {@link Constants#FOOD_INITIAL_POSITION} from the {@code Constants} class.
     */
    private Food food;
    /**
     * The {@code CollisionDetector} object of the current game loop.
     * Checks interactions between game elements.
     */
    private CollisionDetector cd;

    /**
     * The current {@code score} of the player, as determined by the number of fruits eaten.
     */
    private int score;

    /**
     * An instance of the game loop {@code timer}.
     */
    private final Timer timer;

    /**
     * Creates a {@code GameEngine}. By default, {@code isRunning} is set to false.
     * @param timer an instance of the game loop timer so we can start and stop the game.
     */
    public GameEngine(Timer timer) {
        this.timer = timer;
        this.isRunning = false;
        this.score = 0;

        // Intialize the snake and food objects //
        this.snake = new Snake();
        this.food = new Food(Constants.FOOD_INITIAL_POSITION);
        this.cd = new CollisionDetector();

        // Initialize the snake's starting position //
        this.snake.getSnake().add(Constants.SNAKE_INITIAL_POSITION);
    }

    /**
     * Initializes the game elements initial values determined by the {@link Constants} file.
     * The game state is set to running and the score is set to 0.
     */
    public void startGame() {

    }

    /**
     * Updates the game state on each call. The game state updates by moving the {@code snake} and updating its
     * direction, and updating attributes based on a collision check. If the {@code snake} has run into itself or the
     * wall, {@code endGame} is called. If the {@code snake} has run into {@code food} then the {@code snake} will
     * grow, a new food will spawn, and the {@code score} will be incremented.
     */
    public void updateGame() {

    }

    /**
     * If the game is running, ends the game by updating {@code isRunning} to {@code false}, moving the {@code snake}
     * backwards, and stopping the {@code timer}.
     */
    public void endGame() {

    }

    /**
     * Returns {@code true} if the game has ended.
     * @return true if the game has ended, false otherwise.
     */
    public boolean hasEnded() {
        return !isRunning;
    }

    /**
     * Toggles the state of the timer. If the timer is running then it will stop, otherwise it will start.
     */
    public void togglePause() {

    }

    /**
     * Gets the instance of {@code snake} for the current game loop.
     * @return The current {@code snake} instance.
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * Gets the instance of {@code food} for the current game loop.
     * @return The current {@code food} instance.
     */
    public Food getFood() {
        return food;
    }

    /**
     * Gets the {@code score} of the current game loop.
     * @return The current score.
     */
    public int getScore() {
        return score;
    }
}
