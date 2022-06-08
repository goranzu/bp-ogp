package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

/**
 * Base class voor LifeUp en SpeedUp
 *
 * @author Goran Tenic
 * @version 1.0.0
 */
public abstract class PowerUp extends DynamicCircleEntity implements Collided, Collider, UpdateExposer, SceneBorderCrossingWatcher {
    private int ticks = 0;

    public PowerUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation);
        setRadius(radius);

        Direction[] options = {Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN};
        var randomInt = new Random().nextInt(options.length);

        setSpeed(2);
        setDirection(options[randomInt]);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof PlayerSpaceship) {
            remove();
        }
    }

    /*
    Hou de game loop ticks bij,
    als deze hoger is dan een bepaald aantal verwijder de element
     */
    @Override
    public void explicitUpdate(long l) {
        setTicks(getTicks() + 1);
        this.handleRemove();
    }

    /**
     * Abstracte methode die bepaalt na hoeveel ticks het
     * element verwijdert wordt.
     *
     * @author Goran Tenic
     */
    abstract public void handleRemove();

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (SceneBorder.BOTTOM.equals(sceneBorder) || SceneBorder.TOP.equals(sceneBorder) || SceneBorder.LEFT.equals(sceneBorder) || SceneBorder.RIGHT.equals(sceneBorder)) {
            remove();
        }
    }

    public int getTicks() {
        return this.ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

}
