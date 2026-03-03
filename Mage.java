package Ex11;

public class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Pháp sư] " + this.name + " tấn công " + target.getName() + "!");
        if (this.mana >= 5) {
            this.mana -= 5;
            target.takeDamage(this.attackPower);
        } else {
            target.takeDamage(this.attackPower / 2);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Pháp sư] " + this.name + " dùng chiêu cuối lên " + target.getName() + "!");
        if (this.mana >= 50) {
            this.mana -= 50;
            // Tính toán sát thương thực tế để in ra (sau khi trừ giáp của mục tiêu nếu có)
            int rawDamage = this.attackPower * 3;
            int oldHp = target.getHp();
            target.takeDamage(rawDamage);
            int damageTaken = oldHp - target.getHp();

            System.out.println("   -> " + this.name + " tốn 50 mana. " + target.getName() + " mất " + damageTaken + " máu.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | Mana: " + mana);
    }
}