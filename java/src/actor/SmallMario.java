package actor;

public class SmallMario extends AbstractMario implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        decreaseLive();
        if (getLives() < 0) {
            return new DeadMario();
        }
        return this;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public boolean hasMushroom() {
        return false;
    }

    @Override
    public IamSuperMario findsLive() {
        return new SmallMario();
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return this;
    }

    @Override
    public boolean hasFireFlower() {
        return false;
    }

}