/**
 * Changes sprite and adds small buffs (speed +1, damage +2).
 * Logs aura effect on actions.
 */
public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character inner) {
        super(inner);
    }

    @Override
    public void move() {
        System.out.println("✨ Golden aura shines while moving!");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("✨ Golden aura empowers the attack!");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return inner.getSpeed() + 1;
    }

    @Override
    public int getDamage() {
        return inner.getDamage() + 2;
    }

    @Override
    public String getSprite() {
        return "golden_" + inner.getSprite();
    }
}
