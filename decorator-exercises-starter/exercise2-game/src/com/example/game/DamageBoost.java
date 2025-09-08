/**
 * Adds extra damage to the wrapped character.
 */
public class DamageBoost extends CharacterDecorator {
    private int bonus;

    public DamageBoost(Character inner, int bonus) {
        super(inner);
        this.bonus = bonus;
    }

    @Override
    public void attack() {
        System.out.println("Power attack! Damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getDamage() {
        return inner.getDamage() + bonus;
    }
}
