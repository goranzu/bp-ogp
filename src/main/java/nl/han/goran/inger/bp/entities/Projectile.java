package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Projectile extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    public Projectile(Coordinate2D initialLocation, int speed) {
        super("shoot/shoot1.png", initialLocation, new Size(28, 28));

        setMotion(speed + 2, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (SceneBorder.RIGHT.equals(sceneBorder) || SceneBorder.LEFT.equals(sceneBorder)) {
            remove();
        }
    }

    /**
     * TODO: handle collisions
     *
     * @param collider
     */
    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Asteroid || collider instanceof SmallAsteroid) {
            remove();
        }
    }
}
