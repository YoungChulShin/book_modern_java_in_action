package modern.java.ch16.shopapp;

import java.time.LocalDateTime;

public class LogUtils {

  public static void print(String message) {
    System.out.println("[" + LocalDateTime.now() + "] [" + Thread.currentThread().getName() + "]" + message);
  }

}
