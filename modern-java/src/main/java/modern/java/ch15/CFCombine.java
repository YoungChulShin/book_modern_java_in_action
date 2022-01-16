package modern.java.ch15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFCombine {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    int x = 1337;

    CompletableFuture<Integer> a = new CompletableFuture<>();
    CompletableFuture<Integer> b = new CompletableFuture<>();
    CompletableFuture<Integer> c = a.thenCombine(b, Integer::sum);
    executorService.submit(() -> a.complete(f(x)));
    executorService.submit(() -> b.complete(g(x)));

    System.out.println(c.get());
    executorService.shutdown();
  }

  private static int f(int x) {
    Thread thread = Thread.currentThread();

    System.out.println("f 시작: " + thread.getName());
    long a = 0L;
    for (long i = 1L; i < 10000000000L; i++) {
      a++;
    }
    System.out.println("f 종료" + thread.getName());

    return 1;
  }

  private static int g(int x) {
    Thread thread = Thread.currentThread();
    System.out.println("g 시작" + thread.getName());
    long a = 0L;
    for (long i = 1L; i < 10000000000L; i++) {
      a++;
    }
    System.out.println("g 종료" + thread.getName());

    return 2;
  }
}
