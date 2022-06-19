package nl.han.goran.inger.bp.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.goran.inger.bp.entities.Asteroid;
import nl.han.goran.inger.bp.scenes.GameScene;

import java.util.Random;

public class AsteroidSpawner extends EntitySpawner {
    GameScene gameScene;

    public AsteroidSpawner(GameScene gameScene) {
        super(1000 * 10);

        this.gameScene = gameScene;
    }

    @Override
    protected void spawnEntities() {
        var location = new Coordinate2D(gameScene.getWidth() - 100, new Random().nextDouble(gameScene.getHeight()));
        spawn(new Asteroid(location, gameScene));
    }
}
