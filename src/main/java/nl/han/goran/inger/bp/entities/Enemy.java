package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Enemy extends DynamicSpriteEntity implements Collided, Collider, SceneBorderCrossingWatcher {
    public Enemy(Coordinate2D initialLocation) {
        super("enemy/enemy_sprite_sheet.png", initialLocation, new Size(58), 1, 5);

        setAutoCycle(100);
        setMotion(5, Direction.LEFT);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Projectile || collider instanceof PlayerSpaceship) {
            remove();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (SceneBorder.LEFT.equals(sceneBorder)) {
            remove();
        }
    }
}
