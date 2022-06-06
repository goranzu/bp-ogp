package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class LifeUp extends PowerUp {
    public LifeUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation, radius);
        setFill(Color.BLUE);
    }
}
