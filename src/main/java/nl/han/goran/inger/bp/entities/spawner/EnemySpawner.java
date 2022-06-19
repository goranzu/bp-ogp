package nl.han.goran.inger.bp.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.goran.inger.bp.entities.Enemy;
import nl.han.goran.inger.bp.scenes.GameScene;

import java.util.Random;


/**
 * Klasse voor het spawnen van vijande.
 * Met een interval van 3 seconden.
 *
 * @author Goran Tenic
 */
public class EnemySpawner extends EntitySpawner {
    private GameScene gameScene;

    public EnemySpawner(GameScene gameScene) {
        super(1000 * 3);
        this.gameScene = gameScene;
    }


    /**
     * Methode die om de 3 seconden wordt aangeroepen om nieuwe entities te spawnen.
     */
    @Override
    protected void spawnEntities() {
        var location = new Coordinate2D(gameScene.getWidth() + 100, new Random().nextDouble(gameScene.getHeight()));
        spawn(new Enemy(location));
    }
}
