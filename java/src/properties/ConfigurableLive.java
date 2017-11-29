package properties;

import java.util.function.Function;
import java.util.stream.Stream;

import actor.IamSuperMario;

public class ConfigurableLive implements IamAlive {

    private int points;
    private Stream<Function<IamAlive, IamSuperMario>> remainingLives;
    private Stream<Function<IamAlive, IamSuperMario>> onExtraLive;

    public ConfigurableLive(int points, Stream<Function<IamAlive, IamSuperMario>> remainingLives,
            Stream<Function<IamAlive, IamSuperMario>> onExtraLive) {
        this.points = points;
        this.remainingLives = remainingLives;
        this.onExtraLive = onExtraLive;
    }

    @Override
    public IamAlive increase() {
		// remainingLives.add(onExtraLive.get(0));
        return new ConfigurableLive(points, remainingLives, onExtraLive);
    }

    @Override
    public IamSuperMario decrease() {
		// Stream<Function<IamAlive, IamSuperMario>> l =
		// Collections.emptyStream();
		// Collections.copy(l, this.remainingLives);
		Function<IamAlive, IamSuperMario> nextLive = this.remainingLives.findFirst().get();

		IamAlive reducedLive = new ConfigurableLive(this.points, this.remainingLives, this.onExtraLive);
        return nextLive.apply(reducedLive);
    }

}
