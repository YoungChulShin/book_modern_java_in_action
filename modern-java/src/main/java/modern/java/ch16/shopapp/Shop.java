package modern.java.ch16.shopapp;

import java.util.Random;

public class Shop {

  private static Random random = new Random();

  public double getPrice(String product) {
    return calculatePrice(product);
  }

  private double calculatePrice(String product) {
    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  private void delay() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
