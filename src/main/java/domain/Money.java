package domain;

public class Money {
    private int amount;

    private Money(int amount){
        if(!isPositive(amount)){
            throw new MoneyNotPositiveException();
        }

        this.amount = amount;
    }

    public static Money valueOf(int amount) {
        return new Money(amount);
    }

    public boolean isPositive(int amount) {
        return amount > 0;
    }

    public int amount() {
        return amount;
    }
}
