package nl.han.goran.inger.bp;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import nl.han.goran.inger.bp.scenes.GameOverScene;
import nl.han.goran.inger.bp.scenes.GameScene;
import nl.han.goran.inger.bp.scenes.StartScene;

public class SpaceShooter extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Space Shooter");
        setSize(new Size(1100, 700));
    }

    @Override
    public void setupScenes() {
        var customFont = new CustomFont("fonts/RobotoMono-Medium.ttf", 50);
//        addScene(0, new StartScene(startSceneFont, this));
        addScene(1, new GameScene(this));
        addScene(2, new GameOverScene(customFont, this));
    }
}
