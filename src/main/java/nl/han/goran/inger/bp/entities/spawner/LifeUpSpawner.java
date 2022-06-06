package nl.han.goran.inger.bp.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.goran.inger.bp.entities.LifeUp;
import nl.han.goran.inger.bp.entities.PowerUp;

import java.util.Random;

public class LifeUpSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;

    public LifeUpSpawner(double sceneWidth, double sceneHeight) {
        super(1000 * 5);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        var radius = 40;
        var xCoord = new Random().nextInt((int) sceneWidth);
        var yCoord = new Random().nextInt((int) sceneHeight);
        spawn(new LifeUp(new Coordinate2D(xCoord, yCoord), radius));
    }
}
