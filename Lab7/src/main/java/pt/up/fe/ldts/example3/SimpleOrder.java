package pt.up.fe.ldts.example3;

public class SimpleOrder {
    private DiscountInterface discount;
    private double price;

    public SimpleOrder(double price) {

        this.price = price;
        this.discount = new NoDiscount();
    }

    public void setDiscount(DiscountInterface discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
