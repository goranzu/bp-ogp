package nl.han.goran.inger.bp.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.goran.inger.bp.entities.KleineKometen;

public class KleineKometenSpawner extends EntitySpawner {

    private final double sceneWidth ;
    private final double sceneHeight;

    public KleineKometenSpawner(double sceneWidth, double sceneHeight) {
        super(600);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new KleineKometen(spawnLocation()));
    }

    private Coordinate2D spawnLocation() {
        return new Coordinate2D(sceneWidth , sceneHeight / 2);
    }
}
