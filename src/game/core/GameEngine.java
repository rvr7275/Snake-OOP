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

    private void setGameComponents() {
        isRunning = false;
        score = 0;
        snake = new Snake();
        food = new Food(snake);
        cd = new CollisionDetector(snake, food);
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
        } else {
            timer.start();
        }
        isRunning = !isRunning;
        LOGGER.info("Game " + (isRunning ? "Resume" : "Paused"));
    }

    public boolean hasEnded() 
    {
        return !isRunning;
    }

    public Snake getSnake() 
    {
        return snake;
    }

    public Food getFood() 
    {
        return food;
    }

    public int getScore() 
    {
        return score;
    }
}
