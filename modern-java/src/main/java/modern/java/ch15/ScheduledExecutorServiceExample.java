package modern.java.ch15;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

  public static void main(String[] args) {
    ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

    work1();
    scheduledExecutorService.schedule(
        ScheduledExecutorServiceExample::work2,
        10,
        TimeUnit.SECONDS
    );

    scheduledExecutorService.shutdown();
  }

  public static void work1() {
    System.out.println("Hello from Work1");
  }

  public static void work2() {
    System.out.println("Hello from Work2");
  }
}
