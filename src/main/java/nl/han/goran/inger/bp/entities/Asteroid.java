package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import nl.han.goran.inger.bp.scenes.GameScene;

import java.util.Random;

public class Asteroid extends DestroyableObject {
    private int hitPoints = 5;
    private GameScene gameScene;

    public Asteroid(Coordinate2D initialLocation, GameScene gameScene) {
        super("asteroids/asteroid.png", initialLocation, new Size(90));
        this.gameScene = gameScene;
        setRotationSpeed(2);

        setMotion(1, Direction.LEFT.getValue() + new Random().nextDouble(100d));
    }

    /**
     * Als de hitpoints op 0 komen worden er 4 kleinere kometen op speelveld geplaatst.
     * Hiervoor wordt gameScene.addEntity() gebruikt.
     */
    @Override
    public void handleCollison() {
        hitPoints--;
        if (hitPoints < 1) {
            remove();
            for (int i = 0; i < 4; i++) {
                var smallAsteroid = new SmallAsteroid(getAnchorLocation(), new Random().nextDouble(500d), 1);
                gameScene.addEntity(smallAsteroid);
            }
        }

    }
}
