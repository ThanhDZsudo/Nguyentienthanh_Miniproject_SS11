package Ex11;

public class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + this.name + " tấn công " + target.getName() + "!");
        target.takeDamage(this.attackPower);
        System.out.println("   -> " + target.getName() + " mất " + this.attackPower + " máu. HP còn: " + target.getHp() + ".");
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount - this.armor;
        if (actualDamage < 0) {
            actualDamage = 0;
        }
        super.takeDamage(actualDamage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Pháp sư] ... (Lỗi logic hiển thị nếu Chiến binh gọi nhầm, nhưng ở bài này Pháp sư dùng chiêu cuối)");
        // Logic thực tế của Chiến binh (nếu có gọi đến)
        int hpLoss = (int) (this.hp * 0.1);
        this.hp -= hpLoss;
        target.takeDamage(this.attackPower * 2);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | Giáp: " + armor);
    }
}