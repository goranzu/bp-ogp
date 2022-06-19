package nl.han.goran.inger.bp.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

/**
 * Toont het aantal levens op het scherm
 *
 * @author Goran Tenic
 */
public class LivesText extends TextEntity {
    public LivesText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(new CustomFont("fonts/RobotoMono-Medium.ttf", 38));
        setFill(Color.WHITE);
    }

    /**
     * Update de tekst met het aantal levens.
     *
     * @param lives
     */
    public void setLivesText(int lives) {
        setText("Lives: " + lives);
    }
}
