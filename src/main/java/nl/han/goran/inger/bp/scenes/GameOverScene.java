package nl.han.goran.inger.bp.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import nl.han.goran.inger.bp.SpaceShooter;

import java.util.Set;

public class GameOverScene extends DynamicScene implements KeyListener {
    private final CustomFont font;
    private SpaceShooter spaceShooter;

    public GameOverScene(CustomFont font, SpaceShooter spaceShooter) {
        this.font = font;
        this.spaceShooter = spaceShooter;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("background/bg-preview-big.png", true);
//        setBackgroundAudio("music/exports/space-asteroids.mp3");
    }

    @Override
    public void setupEntities() {
        var offSet = 100;
        var xCenter = getWidth() / 2;
        var yCenter = getHeight() / 2;

        var startAgainYText = yCenter + 100;

        var textLocation = new Coordinate2D(xCenter, yCenter);
        var gameOverText = new TextEntity(textLocation, "Game Over");
        var startAgainText = new TextEntity(new Coordinate2D(xCenter, startAgainYText), "Press enter to play again");

        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(this.font);

        startAgainText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        startAgainText.setFill(Color.WHITE);
        startAgainText.setFont(this.font);

        addEntity(gameOverText);
        addEntity(startAgainText);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.ENTER)) {
            spaceShooter.setActiveScene(1);
        }
    }
}
