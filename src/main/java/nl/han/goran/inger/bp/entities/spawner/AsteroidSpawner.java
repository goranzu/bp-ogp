package nl.han.goran.inger.bp.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.goran.inger.bp.entities.Asteroid;
import nl.han.goran.inger.bp.scenes.GameScene;

import java.util.Random;

/**
 * Klasse voor het spawnen van asteroiden.
 * Met een interval van 7 seconden.
 *
 * @author Goran Tenic
 */
public class AsteroidSpawner extends EntitySpawner {
    private GameScene gameScene;

    public AsteroidSpawner(GameScene gameScene) {
        super(1000 * 7);

        this.gameScene = gameScene;
    }

    /**
     * Methode die om de 7 seconden wordt aangeroepen om nieuwe entities te spawnen.
     */
    @Override
    protected void spawnEntities() {
        var location = new Coordinate2D(gameScene.getWidth() - 100, new Random().nextDouble(gameScene.getHeight()));
        spawn(new Asteroid(location, gameScene));
    }
}
