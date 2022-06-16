package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Bullet extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {
    public Bullet(Coordinate2D initialLocation, int speed) {
        super("shoot/shoot1.png", initialLocation, new Size(28, 28));

        setMotion(speed + 2, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (SceneBorder.RIGHT.equals(sceneBorder)) {
            remove();
        }
    }
}
