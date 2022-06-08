package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Bullet extends DynamicSpriteEntity {
    public Bullet(Coordinate2D initialLocation) {
        super("shoot/shoot1.png", initialLocation, new Size(28, 28));

        setMotion(3, Direction.RIGHT);
    }
}
