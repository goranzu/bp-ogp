package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class SpeedUp extends PowerUp{
    public SpeedUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation, radius);
        setFill(Color.GREEN);
    }

    /*
    polymorfisme?
    de speedUp powerups moeten langer op scherm blijven
    ik override deze methode en zorg er voor dat deze
    voor minimaal 2000 ticks bestaan
     */
    @Override
    public void handleRemove() {
        if(getTicks() > 1000) {
            remove();
        }
    }
}
