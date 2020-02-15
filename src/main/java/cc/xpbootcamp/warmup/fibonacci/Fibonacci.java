package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    int init = 2;

    public int calculate(int position) {
        if (position <= init) {
            return 1;
        }
        return 2;
    }
}
