package modern.java.ch15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    int x = 1337;

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Integer> y = executorService.submit(() -> f(x)); // 실행
    Future<Integer> z = executorService.submit(() -> g(x)); // 실행
    System.out.println(y.get() + " " + z.get());

    executorService.shutdown();
  }

  private static int f(int x) {
    System.out.println("f 시작");
    for (int i = 1; i < 100000000; i++) {
      x++;
    }
    System.out.println("f 종료");

    return x;
  }

  private static int g(int x) {
    System.out.println("g 시작");
    for (int i = 1; i < 100000000; i++) {
      x++;
    }
    System.out.println("g 종료");

    return x;
  }
}
