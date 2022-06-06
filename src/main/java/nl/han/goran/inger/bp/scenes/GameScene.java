package nl.han.goran.inger.bp.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.goran.inger.bp.entities.PlayerSpaceship;
import nl.han.goran.inger.bp.entities.spawner.GroteKometenSpawner;
import nl.han.goran.inger.bp.entities.spawner.KleineKometenSpawner;
import nl.han.goran.inger.bp.entities.text.LivesText;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {
    public double xPlayerLocationInScene;
    public double yPlayerLocationInScene;
    private int playerLives = 1;

    public void setupScene() {
        setBackgroundImage("background/bg-preview-big.png", true);
    }

    public void setupEntities() {
        var livesText = new LivesText(new Coordinate2D(0, 0));
        var playerSpaceship = new PlayerSpaceship(new Coordinate2D(0, getHeight() / 2), this, this.playerLives, livesText);
        addEntity(playerSpaceship);
        addEntity(livesText);
    }

    public double getxPlayerLocationInScene() {
        return xPlayerLocationInScene;
    }

    public void setxPlayerLocationInScene(double xPlayerLocationInScene) {
        this.xPlayerLocationInScene = xPlayerLocationInScene;
    }

    public void setyPlayerLocationInScene(double yPlayerLocationInScene) {
        this.yPlayerLocationInScene = yPlayerLocationInScene;
    }

    public double getyPlayerLocationInScene() {
        return yPlayerLocationInScene;
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new KleineKometenSpawner(getWidth(), getHeight()));
        addEntitySpawner(new GroteKometenSpawner(getWidth(), getHeight() / 2));
    }
}
