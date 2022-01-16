package modern.java.ch15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFComplete {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    int x = 1337;

    CompletableFuture<Integer> a = new CompletableFuture<>();
    executorService.submit(() -> a.complete(f(x)));

    int b = g(x);

    // get은 결과를 기다리는
    System.out.println(a.get() + b);
    executorService.shutdown();
  }

  private static int f(int x) {
    Thread thread = Thread.currentThread();

    System.out.println("f 시작: " + thread.getName());
    for (int i = 1; i < 100000000; i++) {
      x++;
    }
    System.out.println("f 종료" + thread.getName());

    return x;
  }

  private static int g(int x) {
    Thread thread = Thread.currentThread();
    System.out.println("g 시작" + thread.getName());
    for (int i = 1; i < 100000000; i++) {
      x++;
    }
    System.out.println("g 종료" + thread.getName());

    return x;
  }
}
