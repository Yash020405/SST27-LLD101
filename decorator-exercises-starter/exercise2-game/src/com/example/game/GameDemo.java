public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        System.out.println("\n--- Base + SpeedBoost + DamageBoost ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();

        System.out.println("\n--- Add GoldenAura ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();

        System.out.println("\n--- Remove GoldenAura (recompose) ---");
        Character withoutAura = buffed; // simply reuse the chain without GoldenAura
        withoutAura.move();
        withoutAura.attack();
    }
}
