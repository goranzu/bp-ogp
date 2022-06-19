package nl.han.goran.inger.bp.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.goran.inger.bp.entities.text.LivesText;
import nl.han.goran.inger.bp.entities.text.PointsText;
import nl.han.goran.inger.bp.scenes.GameScene;

import java.util.Set;

public class PlayerSpaceship extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Collider, Collided {
    private final GameScene gameScene;
    private LivesText livesText;
    private PointsText pointsText;

    private int playerSpeed = 7;

    public PlayerSpaceship(Coordinate2D initialLocation, GameScene gameScene, LivesText livesText, PointsText pointsText) {
        super("player/player_sprite_sheet.png", initialLocation, new Size(74, 42), 1, 6);
        this.gameScene = gameScene;

        this.pointsText = pointsText;
        this.livesText = livesText;
        this.livesText.setLivesText(gameScene.getSpaceShooter().getLives());
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        var speed = this.getPlayerSpeed();

        final double RIGHT_UP = 135d;
        final double RIGHT_DOWN = 45d;
        final double LEFT_UP = 225d;
        final double LEFT_DOWN = 315d;


        if (set.contains(KeyCode.SPACE)) {
            gameScene.addEntity(new Projectile(getAnchorLocation(), getPlayerSpeed(), gameScene, pointsText));
        }

        if (set.contains(KeyCode.RIGHT) && set.contains(KeyCode.UP)) {
            setMotion(speed, RIGHT_UP);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(5);
            } else {
                setCurrentFrameIndex(2);
            }
        } else if (set.contains(KeyCode.RIGHT) && set.contains(KeyCode.DOWN)) {
            setMotion(speed, RIGHT_DOWN);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(4);
            } else {
                setCurrentFrameIndex(1);
            }
        } else if (set.contains(KeyCode.LEFT) && set.contains(KeyCode.UP)) {
            setMotion(speed, LEFT_UP);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(5);
            } else {
                setCurrentFrameIndex(2);
            }
        } else if (set.contains(KeyCode.LEFT) && set.contains(KeyCode.DOWN)) {
            setMotion(speed, LEFT_DOWN);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(4);
            } else {
                setCurrentFrameIndex(1);
            }
        } else if (set.contains(KeyCode.LEFT)) {
            setMotion(speed, Direction.LEFT);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(3);
            } else {
                setCurrentFrameIndex(0);
            }
        } else if (set.contains(KeyCode.RIGHT)) {
            setMotion(speed, Direction.RIGHT);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(3);
            } else {
                setCurrentFrameIndex(0);
            }
        } else if (set.contains(KeyCode.UP)) {
            setMotion(speed, Direction.UP);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(5);
            } else {
                setCurrentFrameIndex(2);
            }
        } else if (set.contains(KeyCode.DOWN)) {
            setMotion(speed, Direction.DOWN);
            if (set.contains(KeyCode.SPACE)) {
                setCurrentFrameIndex(4);
            } else {
                setCurrentFrameIndex(1);
            }
        } else {
            setSpeed(0);
            setCurrentFrameIndex(0);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case TOP -> changeDirection(90);
            case BOTTOM -> setAnchorLocationY(getSceneHeight() - getHeight() - 1);
            case LEFT -> setAnchorLocationX(1);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth() - 1);
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof LifeUp) {
            var newPlayerLives = gameScene.getSpaceShooter().getLives() + 1;
            gameScene.getSpaceShooter().setLives(newPlayerLives);
            livesText.setLivesText(newPlayerLives);
        }

        if (collider instanceof SpeedUp) {
            setPlayerSpeed(getPlayerSpeed() + 2);
        }

        if (collider instanceof Asteroid) {
            var newPlayerLives = gameScene.getSpaceShooter().getLives() - 2;
            gameScene.getSpaceShooter().setLives(newPlayerLives);
            livesText.setLivesText(newPlayerLives);
        }

        if (collider instanceof SmallAsteroid || collider instanceof Enemy) {
            var newPlayerLives = gameScene.getSpaceShooter().getLives() - 1;
            gameScene.getSpaceShooter().setLives(newPlayerLives);
            livesText.setLivesText(newPlayerLives);
        }

        if (collider instanceof Asteroid || collider instanceof SmallAsteroid || collider instanceof Enemy) {
            if (gameScene.getSpaceShooter().getLives() < 1) {
                gameScene.handleEndGame();
            }
        }
    }
}
