package modern.java.ch16.shopapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShopApplication {

  public static void main(String[] args) {
//    System.out.println("====================Search Sync==================");
//    searchSync();

//    System.out.println();
//    System.out.println("====================Search Async==================");
//    searchAsync();

    searchProductPrice();
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
//    Future<Double> futurePrice = shop.getPriceAsync("my favorate product");
    Future<Double> futurePrice = shop.getPriceAsync("ErrorProduct1");
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

  private static void searchProductPrice() {
//    List<Shop> shops = Arrays.asList(
//        new Shop("Shop A"),
//        new Shop("Shop B"),
//        new Shop("Shop C"),
//        new Shop("Shop D"),
//        new Shop("Shop D"));
    List<Shop> shops = new ArrayList<>();
    IntStream.rangeClosed(1, 10).forEach(i -> shops.add(new Shop(String.valueOf(i))));

    ExecutorService executorService = Executors.newFixedThreadPool(20);

    long start = System.currentTimeMillis();

    List<CompletableFuture<String>> priceFuture = shops.stream()
        .map(shop -> CompletableFuture.supplyAsync(() ->
            String.format("%s price is %.2f", shop.getName(), shop.getPrice("viewfinity")), executorService))
        .collect(Collectors.toList());

    List<String> collect = priceFuture.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());

    executorService.shutdown();

    long end = System.currentTimeMillis();
    System.out.println("elapsed : " + (end - start));
    System.out.println(collect);
  }

}
