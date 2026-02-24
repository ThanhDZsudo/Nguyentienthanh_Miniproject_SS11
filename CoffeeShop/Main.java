package Ex11.CoffeeShop;

public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("CF01", "Bạc sỉu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nước rau má", 40000, 10);
        drinks[2] = null;

        System.out.println("=== HÓA ĐƠN ĐỒ UỐNG ===");

        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] != null) {
                System.out.println("\n--- Đồ uống " + (i + 1) + " ---");

                drinks[i].displayInfo();

                System.out.println("Thành tiền: " + drinks[i].calculatePrice());

                if (drinks[i] instanceof IMixable) {
                    ((IMixable) drinks[i]).mix();
                }
            }
        }
    }
}
