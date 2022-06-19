package nl.han.goran.inger.bp.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import nl.han.goran.inger.bp.scenes.GameScene;


/**
 * Toont het aantal punten op het scherm
 *
 * @author Goran Tenic
 */
public class PointsText extends TextEntity {
    private GameScene gameScene;

    public PointsText(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);

        this.gameScene = gameScene;

        setFont(new CustomFont("fonts/RobotoMono-Medium.ttf", 30));
        setFill(Color.WHITE);

        setPointsText(this.gameScene.getSpaceShooter().getGamePoints());
    }


    /**
     * Update de tekst met het aantal punten.
     *
     * @param points
     */
    public void setPointsText(int points) {
        setText("Points " + points);
    }
}
