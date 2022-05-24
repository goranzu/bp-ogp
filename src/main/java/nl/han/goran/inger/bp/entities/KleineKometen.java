package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class KleineKometen extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {

    public KleineKometen(Coordinate2D location){
        super("asteroids/asteroid-small.png", location);
        setMotion(2, 320d);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        switch (border) {
            case TOP, BOTTOM -> changeDirection(245);
        }
    }
}

