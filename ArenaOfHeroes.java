package Ex11;

public class ArenaOfHeroes {
    public static void main(String[] args) {
        System.out.println("=== ARENA OF HEROES ===");

        GameCharacter[] characters = new GameCharacter[3];

        characters[0] = new Warrior("Yasuo", 500, 50, 20);
        characters[1] = new Mage("Veigar", 300, 40, 200);

        characters[2] = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("3. [Quái vật] Goblin tấn công!");
                System.out.println("   -> Goblin cắn trộm " + target.getName() + "... Gây 10 sát thương.");
                target.takeDamage(10);
            }
        };

        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");

        // 1. Warrior tấn công Goblin
        System.out.print("1. ");
        characters[0].attack(characters[2]);
        System.out.println();

        // 2. Mage dùng chiêu cuối lên Warrior
        System.out.print("2. ");
        if (characters[1] instanceof Mage) {
            ((Mage) characters[1]).useUltimate(characters[0]);
        }
        System.out.println();

        // 3. Goblin đánh Mage
        characters[2].attack(characters[1]);
        System.out.println();

        System.out.println("=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        for (GameCharacter character : characters) {
            if (character != null) {
                character.displayInfo();
            }
        }
    }
}