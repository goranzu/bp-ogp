package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.goran.inger.bp.entities.text.PointsText;
import nl.han.goran.inger.bp.scenes.GameScene;

public class Projectile extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    GameScene gameScene;
    PointsText pointsText;

    public Projectile(Coordinate2D initialLocation, int speed, GameScene gameScene, PointsText pointsText) {
        super("shoot/shoot1.png", initialLocation, new Size(28, 28));

        this.gameScene = gameScene;
        this.pointsText = pointsText;

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
        if (collider instanceof Enemy) {
            var spaceShooter = gameScene.getSpaceShooter();
            spaceShooter.setGamePoints(spaceShooter.getGamePoints() + 1);
            pointsText.setPointsText(spaceShooter.getGamePoints());
            remove();

            // at 15 points end the game
            if (spaceShooter.getGamePoints() > 14) {
                spaceShooter.setActiveScene(2);
            }
        }

        if (collider instanceof Asteroid || collider instanceof SmallAsteroid) {
            remove();
        }
    }
}
