package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;


public class FibonacciTest {
    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        //given
        int position = 1;

        //when
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(position);

        //then
        assertEquals(result, 1);

    }

    @Test
    public void should_return_2_when_calculate_given_position_is_1() {
        //given
        int position = 2;

        //when
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(position);

        //then
        assertEquals(result, 1);

    }

}
