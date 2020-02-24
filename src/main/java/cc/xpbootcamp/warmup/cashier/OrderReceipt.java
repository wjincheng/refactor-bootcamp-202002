package cc.xpbootcamp.warmup.cashier;

import static java.util.Calendar.WEDNESDAY;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * OrderReceipt prints the details of order including customer description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. And it has a 0.02 discount every Wednesday.
 * It computes the total order amount (amount of individual lineItems +
 * total sales tax - discount) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;
    private StringBuilder output;
    private Date date = new Date();

    public OrderReceipt(Order order) {
        this.order = order;
        this.output = new StringBuilder();
    }

    public String printReceipt() {
        addHeader();
        addDate();
        addProductInfo();
        addSalesTax();
        addDiscount();
        addTotalAmount();
        return output.toString();
    }

    private void addDiscount(){
        if (order.isDiscount()) {
            output.append("折扣:")
                .append('\t')
                .append(order.getDiscount())
                .append('\n');
        }
    }

    private void addDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日，EEEE", Locale.CHINA);
        output.append(simpleDateFormat.format(date))
        .append("\n");
    }

    private void addHeader() {
        output.append("======老王超市，值得信赖======\n");
    }

    private void addProductInfo() {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.totalAmount()).append('\n');
        }
    }

    private void addSalesTax() {
        output.append("税额:").append('\t').append(order.getTotalSalesTax())
            .append('\n');
    }

    private void addTotalAmount() {
        output.append("总价:").append('\t').append(order.getTotalPrice())
            .append('\n');
    }

}