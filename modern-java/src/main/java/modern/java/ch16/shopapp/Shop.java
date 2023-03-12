package modern.java.ch16.shopapp;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

  private static final Random random = new Random();
  private final String name;

  public Shop(String name) {
    this.name = name;
  }

  public double getPrice(String product) {
    return calculatePrice(product);
  }

  public void doShopping() {
    LogUtils.print("start shopping for 2000 msecs");
    delay(2000);
    LogUtils.print("end shopping");
  }

//  public Future<Double> getPriceAsync(String product) {
//    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//    new Thread(() -> {
//      try {
//        if (product.equals("ErrorProduct")) {
//          throw new RuntimeException("Product is not available");
//        }
//        double price = calculatePrice(product);
//        LogUtils.print(product + " price is " + price);
//        futurePrice.complete(price);
//      } catch (Exception e) {
//        futurePrice.completeExceptionally(e);
//      }
//    }).start();
//
//    return futurePrice;
//  }

  public Future<Double> getPriceAsync(String product) {
    return CompletableFuture.supplyAsync(() -> {
      if (product.equals("ErrorProduct")) {
        throw new RuntimeException("Product is not available");
      }
      double price = calculatePrice(product);
      LogUtils.print(product + " price is " + price);
      return price;
    });
//    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//    new Thread(() -> {
//      try {
//        if (product.equals("ErrorProduct")) {
//          throw new RuntimeException("Product is not available");
//        }
//        double price = calculatePrice(product);
//        LogUtils.print(product + " price is " + price);
//        futurePrice.complete(price);
//      } catch (Exception e) {
//        futurePrice.completeExceptionally(e);
//      }
//    }).start();
//
//    return futurePrice;
  }

  private double calculatePrice(String product) {
    delay(3000);
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  private void delay(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
