package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

/**
 * Als de speler een collision met deze element heeft
 * wordt er 1 punt aan het levens totaal toegevoegd.
 *
 * @author Goran Tenic
 * @version 1.0.0
 */
public class LifeUp extends PowerUp {
    public LifeUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation, radius);
        setFill(Color.BLUE);
    }
}
