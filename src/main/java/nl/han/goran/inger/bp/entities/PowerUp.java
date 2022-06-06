package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

public class PowerUp extends DynamicCircleEntity implements Collided, Collider {
    public PowerUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation);
        setRadius(radius);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof PlayerSpaceship) {
            remove();
        }
    }
}
