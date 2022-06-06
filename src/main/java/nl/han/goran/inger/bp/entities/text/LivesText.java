package nl.han.goran.inger.bp.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

public class LivesText extends TextEntity {
    public LivesText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(new CustomFont("fonts/RobotoMono-Medium.ttf", 38));
        setFill(Color.WHITE);
    }

    public void setLivesText(int lives) {
        setText("Lives: " + lives);
    }
}
