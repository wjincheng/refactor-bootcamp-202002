package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

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

    @Test
    public void should_return_3_when_calculate_given_position_is_2() {
        //given
        int position = 3;

        //when
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(position);

        //then
        assertEquals(result, 2);
    }

    @Test
    public void should_return_4_when_calculate_given_position_is_3() {
        //given
        int position = 4;

        //when
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(position);

        //then
        assertEquals(result, 3);
    }

    @Test
    public void should_return_10_when_calculate_given_position_is_55() {
        //given
        int position = 10;

        //when
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(position);

        //then
        assertEquals(result, 55);
    }

}
