package pt.up.fe.ldts.example3;

public class NoDiscount implements DiscountInterface {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}