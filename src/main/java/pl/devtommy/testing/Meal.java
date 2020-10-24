package pl.devtommy.testing;

public class Meal {
    private int price;

    public Meal(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount) {
        return this.price - discount;
    }
}
