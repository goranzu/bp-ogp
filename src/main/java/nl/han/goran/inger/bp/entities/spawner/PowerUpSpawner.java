package nl.han.goran.inger.bp.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.goran.inger.bp.entities.LifeUp;
import nl.han.goran.inger.bp.entities.SpeedUp;

import java.util.Random;


/**
 * Klasse voor het spawnen van power ups.
 * Met een interval van 5 seconden.
 *
 * @author Goran Tenic
 */
public class PowerUpSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;

    public PowerUpSpawner(double sceneWidth, double sceneHeight) {
        super(1000 * 5);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }


    /**
     * Methode die om de 5 seconden wordt aangeroepen om nieuwe entities te spawnen.
     */
    @Override
    protected void spawnEntities() {
        var radius = 40;
        var xCoord = new Random().nextInt((int) sceneWidth);
        var yCoord = new Random().nextInt((int) sceneHeight);
        if(new Random().nextInt(10) <= 2) {
            spawn(new LifeUp(new Coordinate2D(xCoord, yCoord), radius));
        } else {
            spawn(new SpeedUp(new Coordinate2D(xCoord, yCoord), radius));
        }
    }
}
