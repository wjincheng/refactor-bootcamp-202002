package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;
    private StringBuilder output;

    public OrderReceipt(Order order) {
        this.order = order;
        this.output = new StringBuilder();
    }

    public String printReceipt() {
        addHeader();
        addCustomer();
        addProductInfo();
        addSalesTax();
        addTotalAmount();
        return output.toString();
    }

    private void addHeader() {
        output.append("======Printing Orders======\n");
    }

    private void addCustomer() {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
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
        output.append("Sales Tax").append('\t').append(getTotalSalesTax());
    }

    private void addTotalAmount() {
        double total = getTotalOrderPrice() + getTotalSalesTax();
        output.append("Total Amount").append('\t').append(total);
    }

    private double getTotalSalesTax() {
        double salesTaxRate = 0.1;
        return getTotalOrderPrice() * salesTaxRate;
    }

    private double getTotalOrderPrice() {
        return order.getLineItems().stream().mapToDouble(LineItem::totalAmount).sum();
    }

}