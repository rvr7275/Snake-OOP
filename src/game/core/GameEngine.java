package game.core;

import game.LoggerSetup;
import game.utils.CollisionDetector;
import javax.swing.*;
import java.util.logging.Logger;

/**
 * The {@code GameEngine} is used to store instances of all major
 * components of the current game loop and manages the state of the game.
 */
public class GameEngine {
    private static final Logger LOGGER = LoggerSetup.getLogger(GameEngine.class.getName());
    private boolean isRunning;
    private Snake snake;
    private Food food;
    private CollisionDetector cd;
    private int score;
    private final Timer timer;

    /**
     * Constructs the game engine
     * @param timer Manages game updates
     */
    public GameEngine(Timer timer) {
        this.timer = timer;
        setGameComponents();
    }

    /**
     * Initializes game components
     */
    private void setGameComponents() {
        isRunning = true;
        score = 0;
        snake = new Snake();
        food = new Food(snake);
        cd = new CollisionDetector(snake, food);
        timer.start();
    }

    /**
     * Starts the game and resets all states
     */
    public void startGame() {
        setGameComponents();
        isRunning = true;
        timer.start();
        LOGGER.info("Game has started.");
    }

    /**
     * Handles snake movement, collision detection,
     * and increases score for eating food
     */
    public void updateGame() {
        if (!isRunning) return;

        snake.move();
        handleCollisions();
    }

    /**
     * Checks for collisions and does the necessary actions
     */
    private void handleCollisions() {
        if (cd.wallCollision() || cd.bodyCollision()) {
            endGame();
        } else if (cd.foodCollision()) {
            snake.grow();
            score++;
            food.spawn();
        }
    }

    /**
     * Ends game
     */
    public void endGame() {
        if (isRunning) {
            snake.moveBackwards();
            isRunning = false;
            timer.stop();
            LOGGER.info("Score: " + score);
        }
    }

    /**
     * Pause and unpause game
     */
    public void togglePause() {
        if (timer.isRunning()) {
            timer.stop();
            LOGGER.info("Game Paused");
        } else {
            timer.start();
            LOGGER.info("Game Resumed");
        }

    }
    /**
     * Returns {@code true} if the game has ended.
     * @return true if the game has ended, false otherwise.
     */
    public boolean hasEnded()
    {
        return !isRunning;
    }

    /**
     * Gets the instance of {@code snake} for the current game loop.
     * @return The current {@code snake} instance.
     */
    public Snake getSnake()
    {
        return snake;
    }
    /**
     * Gets the instance of {@code food} for the current game loop.
     * @return The current {@code food} instance.
     */
    public Food getFood()
    {
        return food;
    }
    /**
     * Gets the {@code score} of the current game loop.
     * @return The current score.
     */
    public int getScore()
    {
        return score;
    }
}
