package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public abstract class DestroyableObject extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher, SceneBorderCrossingWatcher {
    protected DestroyableObject(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Projectile) {
            this.handleCollison();
        }

        if (collider instanceof PlayerSpaceship) {
            remove();
        }
    }

    public abstract void handleCollison();

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        // handle border touching
        changeDirection(new Random().nextDouble(385d));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
