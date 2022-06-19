package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

/**
 * Basis voor Asteroid en SmallAsteroid klassen,
 * Hier wordt de collision, boundary functionaliteit bepaalt.
 */
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
        if (SceneBorder.TOP.equals(sceneBorder)) {
            changeDirection(Direction.DOWN.getValue() + 50d);
        }

        if (SceneBorder.BOTTOM.equals(sceneBorder)) {
            changeDirection(Direction.UP.getValue() + 50d);
        }

        if (SceneBorder.RIGHT.equals(sceneBorder)) {
            changeDirection(Direction.LEFT.getValue() + 50d);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (SceneBorder.LEFT.equals(sceneBorder)) {
            remove();
        }
    }
}
