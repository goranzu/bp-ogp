package nl.han.goran.inger.bp.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import nl.han.goran.inger.bp.scenes.GameScene;

public class PointsText extends TextEntity {
    GameScene gameScene;
    public PointsText(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);

        this.gameScene = gameScene;

        setFont(new CustomFont("fonts/RobotoMono-Medium.ttf", 30));
        setFill(Color.WHITE);

        setPointsText(gameScene.getSpaceShooter().getGamePoints());
    }

    public void setPointsText(int points) {
        setText("Points " + points);
    }
}
