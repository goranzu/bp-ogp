package nl.han.goran.inger.bp.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

/*
deze class wordt toegevoegd in de gameScene class
met de addEntities methode.
De speler class krijgt ook een instance van deze class
om de het aantal levens te verhogen of verlagen,
afhankelijk of een power up is geraakt of een komeet/vijand
 */
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
