package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;

/*
Ik heb hier een abstract class van gemaakt omdat er nooit een
instance van deze class gemaakt mag worden.
Er worden alleen instances gemaakt van classen die overerven van deze class.
 */
public abstract class PowerUp extends DynamicCircleEntity implements Collided, Collider, UpdateExposer {
    private int ticks = 0;
    final int liveForInMs = 350;

    public PowerUp(Coordinate2D initialLocation, int radius) {
        super(initialLocation);
        setRadius(radius);
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

    // Vraag of gebruik van abstract methodes polymorfisme is.
    public abstract void handleRemove();

    public int getTicks() {
        return this.ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public int getLiveForInMs() {
        return this.liveForInMs;
    }
}
