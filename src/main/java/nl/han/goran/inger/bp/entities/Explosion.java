package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Explosion extends DynamicSpriteEntity {
    public Explosion(Coordinate2D initialLocation) {
        super("explosion/explosion.png", initialLocation, new Size(50), 1, 5);
        setAutoCycle(1);
    }
}
