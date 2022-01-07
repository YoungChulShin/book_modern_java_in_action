package modern.java.ch7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PlayGround {

  public long sequentialSum(long n) {
    return Stream.iterate(0, i -> i + 1)
        .limit(n)
        .reduce(0, Integer::sum);
  }

  public long parallelSum(long n) {
    return Stream.iterate(0, i -> i + 1)
        .limit(n)
        .parallel()
        .reduce(0, Integer::sum);
  }

  public long sideEffectSum(long n) {
    Accumulator accumulator = new Accumulator();
    LongStream.rangeClosed(1, n).forEach(accumulator::add);

    System.out.println(accumulator.total);
    return accumulator.total;
  }

  public long sideEffectParallelSum(long n) {
    Accumulator accumulator = new Accumulator();
    LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);

    System.out.println(accumulator.total);
    return accumulator.total;
  }
}
