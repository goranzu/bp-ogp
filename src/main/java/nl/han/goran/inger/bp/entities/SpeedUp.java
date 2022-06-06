package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class SpeedUp extends PowerUp{
    public SpeedUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation, radius);
        setFill(Color.GREEN);
    }
}
