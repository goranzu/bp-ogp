package nl.han.goran.inger.bp;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import nl.han.goran.inger.bp.scenes.GameOverScene;
import nl.han.goran.inger.bp.scenes.GameScene;
import nl.han.goran.inger.bp.scenes.StartScene;

/**
 * Het startpunt van het spel.
 * Hier hou ik een aantal globale variabelen bij en
 * worden alle game scenes toegevoegd.
 *
 * @author Goran Tenic
 */
public class SpaceShooter extends YaegerGame {
    private int gamePoints = 0;

    private int lives = 3;

    /**
     * Startpunt van het programma.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Instellen van de naam van het spel en de groote van het spel venster.
     */
    @Override
    public void setupGame() {
        setGameTitle("Space Shooter");
        setSize(new Size(1100, 700));
    }

    /**
     * Het toevoegen van de game scenes aan de game engine.
     */
    @Override
    public void setupScenes() {
        var customFont = new CustomFont("fonts/RobotoMono-Medium.ttf", 50);
        addScene(0, new StartScene(customFont, this));
        addScene(1, new GameScene(this));
        addScene(2, new GameOverScene(customFont, this));
    }

    public int getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(int gamePoints) {
        this.gamePoints = gamePoints;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
