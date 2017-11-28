package properties;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import actor.IamSuperMario;

public class ConfigurableLive implements IamAlive {

    private int points;
    private List<Function<IamAlive, IamSuperMario>> remainingLives;
    private List<Function<IamAlive, IamSuperMario>> onExtraLive;

    public ConfigurableLive(int points, List<Function<IamAlive, IamSuperMario>> remainingLives,
            List<Function<IamAlive, IamSuperMario>> onExtraLive) {
        this.points = points;
        this.remainingLives = remainingLives;
        this.onExtraLive = onExtraLive;
    }

    @Override
    public IamAlive increase() {
        remainingLives.add(onExtraLive.get(0));
        return new ConfigurableLive(points, remainingLives, onExtraLive);
    }

    @Override
    public IamSuperMario decrease() {
        List<Function<IamAlive, IamSuperMario>> l = Collections.emptyList();
        Collections.copy(l, this.remainingLives);
        Function<IamAlive, IamSuperMario> nextLive = l.remove(0);
        IamAlive reducedLive = new ConfigurableLive(this.points, l, this.onExtraLive);
        return nextLive.apply(reducedLive);
    }

}
