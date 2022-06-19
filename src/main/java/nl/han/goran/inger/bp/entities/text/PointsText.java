package nl.han.goran.inger.bp.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

public class PointsText extends TextEntity {
    public PointsText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(new CustomFont("fonts/RobotoMono-Medium.ttf", 30));
        setFill(Color.WHITE);

        setPointsText(0);
    }

    public void setPointsText(int points) {
        setText("Points " + points);
    }
}
