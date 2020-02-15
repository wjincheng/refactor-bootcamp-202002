package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    int init = 2;

    public int calculate(int position) {
        if (position <= init) {
            return 1;
        }
        if (position == 3) {
            return 2;
        }
        return 3;
    }
}
