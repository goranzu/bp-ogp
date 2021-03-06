package nl.han.goran.inger.bp.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.goran.inger.bp.SpaceShooter;
import nl.han.goran.inger.bp.entities.PlayerSpaceship;
import nl.han.goran.inger.bp.entities.spawner.AsteroidSpawner;
import nl.han.goran.inger.bp.entities.spawner.EnemySpawner;
import nl.han.goran.inger.bp.entities.spawner.PowerUpSpawner;
import nl.han.goran.inger.bp.entities.text.LivesText;
import nl.han.goran.inger.bp.entities.text.PointsText;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {
    private SpaceShooter spaceShooter;

    public GameScene(SpaceShooter spaceShooter) {
        this.spaceShooter = spaceShooter;
    }

    public void setupScene() {
        setBackgroundImage("background/bg-preview-big.png", true);
    }

    public void setupEntities() {
        var livesText = new LivesText(new Coordinate2D(0, 0));
        var pointsText = new PointsText(new Coordinate2D(getWidth() / 2, 0), this);
        var playerSpaceship = new PlayerSpaceship(new Coordinate2D(0, getHeight() / 2), this, livesText, pointsText);
        pointsText.setAnchorPoint(AnchorPoint.TOP_CENTER);

        addEntity(playerSpaceship);
        addEntity(livesText);
        addEntity(pointsText);
    }

    /**
     * Ik override deze methode en maak hem public zodat de addEntity methode beschikbaar
     * is in de PlayerSpaceShip class.
     *
     * @param yaegerEntity
     */
    @Override
    public void addEntity(YaegerEntity yaegerEntity) {
        super.addEntity(yaegerEntity);
    }

    public void handleEndGame() {
        spaceShooter.setActiveScene(2);
    }


    @Override
    public void setupEntitySpawners() {
        var sceneWidth = getWidth();
        var sceneHeight = getHeight();
        var powerUpSpawner = new PowerUpSpawner(sceneWidth, sceneHeight);
        var asteroidSpawner = new AsteroidSpawner(this);
        var enemySpawner = new EnemySpawner(this);

        addEntitySpawner(powerUpSpawner);
        addEntitySpawner(asteroidSpawner);
        addEntitySpawner(enemySpawner);
    }

    public SpaceShooter getSpaceShooter() {
        return spaceShooter;
    }
}
