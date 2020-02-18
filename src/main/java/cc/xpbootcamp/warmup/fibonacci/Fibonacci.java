package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public long calculate(int position) {
        long[] positionArray =new long[position];

        if (position == 1 || position == 2) {
            return 1;
        }
        
        positionArray[0] = 1;
        positionArray[1] = 1;

        for (int index = 2; index < positionArray.length; index ++) {
            positionArray[index] = positionArray[index -1] + positionArray[index - 2];
        }
        return positionArray[position - 1];
    }
}
