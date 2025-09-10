public class SpeedBoost extends CharacterDecorator {
    private int bonus;

    public SpeedBoost(Character inner, int bonus) {
        super(inner);
        this.bonus = bonus;
    }

    @Override
    public void move() {
        System.out.println("Moving faster! Speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return inner.getSpeed() + bonus;
    }
}
