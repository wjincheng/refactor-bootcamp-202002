package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Calendar.WEDNESDAY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("税额:\t6.5"));
        if (calendar.get(Calendar.DAY_OF_WEEK) == WEDNESDAY) {
            assertThat(output, containsString("折扣:\t1.3"));
            assertThat(output, containsString("总价:\t70.2"));
        } else {
            assertThat(output, containsString("总价:\t71.5"));
        }
    }

    @Test
    public void shouldPrintHeaderInformationOnOrder() {
        Order order = new Order(null, null, new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("======老王超市，值得信赖======"));
    }

    @Test
    public void shouldPrintDateInformationOnOrder() {
        Order order = new Order(null, null, new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日，EEEE", Locale.CHINA);

        String output = receipt.printReceipt();

        assertThat(output, containsString(simpleDateFormat.format(date)));
    }
}