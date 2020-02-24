package cc.xpbootcamp.warmup.cashier;

import static java.util.Calendar.WEDNESDAY;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
    List<LineItem> lineItemList;

    public Order(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public double getTotalSalesTax() {
        double salesTaxRate = 0.1;
        return getTotalOrderPrice() * salesTaxRate;
    }

    public double getTotalOrderPrice() {
        return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public  double getTotalPrice() {
        if (isDiscount()) {
            return getTotalOrderPrice() + getTotalSalesTax() - getDiscount();
        }
        return getTotalOrderPrice() + getTotalSalesTax();
    }

    public boolean isDiscount(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == WEDNESDAY;
    }

    public double getDiscount() {
        double discountRate = 0.02;
        return discountRate * getTotalOrderPrice();
    }
}
