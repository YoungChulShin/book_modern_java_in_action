package modern.java.ch16.shopapp;

import java.util.concurrent.Future;

public class ShopApplication {

  public static void main(String[] args) {
    System.out.println("====================Search Sync==================");
    searchSync();

    System.out.println();
    System.out.println("====================Search Async==================");
    searchAsync();
  }

  private static void searchSync() {
    Shop shop = new Shop("BestShop");
    long start = System.nanoTime();
    LogUtils.print("Start getPrice");
    LogUtils.print("price is " + shop.getPrice("my favorate product"));
    shop.doShopping();

    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    LogUtils.print("Price returned after " + retrievalTime + " msecs");
  }

  private static void searchAsync() {
    Shop shop = new Shop("BestShop");
    long start = System.nanoTime();
    LogUtils.print("Start getPrice");
    Future<Double> futurePrice = shop.getPriceAsync("my favorate product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    LogUtils.print("Stop getPrice after " + invocationTime + " msecs");

    shop.doShopping();
    try {
      double price = futurePrice.get();
      LogUtils.print("price is " + price);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    LogUtils.print("Price returned after " + retrievalTime + " msecs");
  }

}
