package modern.java.ch7;

public class ForkJoinSumCalculator extends java.util.concurrent.RecursiveTask<Long> {

  public static final long THRESHOLD = 10_000;

  private final long[] numbers;
  private final int start;
  private final int end;

  public ForkJoinSumCalculator(long[] numbers) {
    this(numbers, 0, numbers.length);
  }

  private ForkJoinSumCalculator(long[] numbers, int start, int end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    int length = end - start;
    if (length < THRESHOLD) {
      return computeSequentially();
    }

    ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
    leftTask.fork();  // 다른 타스크로 작업을 시작한다
    ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
    Long rightResult = rightTask.compute();// 두번째 서비태스크를 실행한다
    Long leftResult = leftTask.join();  // 첫번째 태스크의 결과를 읽거나 기다린다

    return leftResult + rightResult;
  }

  private long computeSequentially() {
    long sum = 0;
    for (int i = start; i < end; i++) {
      sum += numbers[i];
    }

    return sum;
  }
}
