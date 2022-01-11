package modern.java.ch7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Main {

  public static void main(String[] args) {
    PlayGround playGround = new PlayGround();
//    System.out.println(playGround.sequentialSum(10));
//    System.out.println(playGround.parallelSum(10));

    // System.out.println(Runtime.getRuntime().availableProcessors());
//    playGround.sideEffectSum(10_000_000L);
//    playGround.sideEffectParallelSum(10_000_000L);

    System.out.println(forkJoinSum(1000000));
  }

  public static long forkJoinSum(long n) {
    long[] numbers = LongStream.rangeClosed(1, n).toArray();
    ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
    return new ForkJoinPool().invoke(task);
  }
}
