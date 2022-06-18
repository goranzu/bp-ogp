package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SmallAsteroid extends DestroyableObject {
    int hitPoints = 1;

    public SmallAsteroid(Coordinate2D initialLocation, double direction, int speed) {
        super("asteroids/asteroid-small.png", initialLocation, new Size(30));
        setMotion(speed, direction);
        setRotationSpeed(2);
    }

    @Override
    public void handleCollison() {
        this.hitPoints--;
        if (this.hitPoints < 1) {
            remove();
        }

    }
}
