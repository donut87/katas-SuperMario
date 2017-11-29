package game;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import actor.IamSuperMario;
import actor.SmallMario;
import properties.IamAlive;

public class MarioGame {

    public static MarioGame startWithThreeLives() {
        // IamAlive extraLive = //Enumerable.Repeat(KleinerMario(), 1);

        List<Function<IamAlive, IamSuperMario>> remainingLives;
        List<Function<IamAlive, IamSuperMario>> onExtraLive = Collections.emptyList();
        onExtraLive.add(live -> new SmallMario());
        // var begrenztesLeben = Enumerable
        // .Repeat(KleinerMario(), anzahl)
        // .Concat(Unendlich(ToterMario()));
        //
        // var konfiguriertesLeben = new KonfigurierbaresLeben(0, begrenztesLeben,
        // extraLeben);
		// ConfigurableLive live = new ConfigurableLive(0, remainingLives,
		// onExtraLive);
        return new MarioGame();
    }

}
