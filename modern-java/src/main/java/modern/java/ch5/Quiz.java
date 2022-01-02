package modern.java.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import modern.java.ch5.Dish.Type;

public class Quiz {

  public void quiz_5_1_solve() {
    Dish dish1 = new Dish("a", false, 100, Type.MEAT);
    Dish dish2 = new Dish("b", false, 100, Type.FISH);
    Dish dish3 = new Dish("c", false, 100, Type.MEAT);
    Dish dish4 = new Dish("d", false, 100, Type.MEAT);

    List<Dish> dishes = Arrays.asList(dish1, dish2, dish3, dish4);
    List<Dish> collect = dishes.stream()
        .filter(dish -> dish.getType() == Type.MEAT)
        .limit(2)
        .collect(Collectors.toList());
  }

  public void quiz_5_2_solve() {
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

    List<Integer> collect = values.stream()
        .map(v -> v * v)
        .collect(Collectors.toList());

    for (Integer i : collect) {
      System.out.println(i);
    }
  }

  public void quiz_5_2_2_solve() {
    List<Integer> values = Arrays.asList(1, 2, 3);
    List<Integer> values2 = Arrays.asList(3, 4);

    List<int[]> collect = values.stream()
        .flatMap(v -> values2.stream().map(v2 -> new int[]{v, v2}))
        .collect(Collectors.toList());

    for (int[] i : collect) {
      System.out.println(i[0] + " : " + i[1]);
    }
  }

  public void quiz_5_2_3_solve() {
    List<Integer> values = Arrays.asList(1, 2, 3);
    List<Integer> values2 = Arrays.asList(3, 4);

//    List<int[]> collect = values.stream()
//        .flatMap(v -> values2.stream().map(v2 -> new int[]{v, v2}))
//        .filter(v -> (v[0] + v[1]) % 3 == 0)
//        .collect(Collectors.toList());

    List<int[]> collect = values.stream()
        .flatMap(v ->
            values2.stream()
                .filter(j -> (v + j) % 3 == 0)
                .map(v2 -> new int[]{v, v2}))
        .collect(Collectors.toList());

    for (int[] i : collect) {
      System.out.println(i[0] + " : " + i[1]);
    }
  }

  public void quiz_5_3_solve() {
    Dish dish1 = new Dish("a", false, 100, Type.MEAT);
    Dish dish2 = new Dish("a", false, 100, Type.MEAT);
    Dish dish3 = new Dish("a", false, 100, Type.MEAT);
    Dish dish4 = new Dish("a", false, 100, Type.MEAT);

    List<Dish> dishes = Arrays.asList(dish1, dish2, dish3, dish4);
    Integer reduce = dishes.stream()
        .map(d -> 1)
        .reduce(0, Integer::sum);
  }

  public void quiz_5_6_1() {
    List<Transaction> transactions = getTransactionData();

    List<Integer> collect = transactions.stream()
        .filter(transaction -> transaction.getYear() == 2011)
        .map(Transaction::getValue)
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

    for (Integer value : collect) {
      System.out.println(value);
    }
  }

  public void quiz_5_6_2() {
    List<Transaction> transactions = getTransactionData();

    List<String> collect = transactions.stream()
        .map(t -> t.getTrader().getCity())
        .distinct()
        .collect(Collectors.toList());

    for (String value : collect) {
      System.out.println(value);
    }
  }

  public void quiz_5_6_3() {
    List<Transaction> transactions = getTransactionData();

    List<Trader> values = transactions.stream()
        .map(Transaction::getTrader)
        .filter(t -> t.getCity().equals("Cambridge"))
        .distinct()
        .sorted(Comparator.comparing(Trader::getName))
        .collect(Collectors.toList());

    for (Trader value : values) {
      System.out.println(value);
    }
  }

  public void quiz_5_6_4() {
    List<Transaction> transactions = getTransactionData();

    String reduce = transactions.stream()
        .map(t -> t.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (t1, t2) -> t1 + " " + t2);

    String reduce2 = transactions.stream()
        .map(t -> t.getTrader().getName())
        .distinct()
        .sorted()
        .collect(Collectors.joining());

    System.out.println(reduce);
    System.out.println(reduce2);
  }

  public void quiz_5_6_5() {
    List<Transaction> transactions = getTransactionData();

    boolean milan = transactions.stream()
        .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

    System.out.println(milan);
  }
  public void quiz_5_6_6() {
    List<Transaction> transactions = getTransactionData();

    Integer sum = transactions.stream()
        .filter(t -> t.getTrader().getCity().equals("Cambridge"))
        .map(t -> t.getValue())
        .reduce(0, Integer::sum);

    System.out.println(sum);
  }

  public void quiz_5_6_7() {
    List<Transaction> transactions = getTransactionData();

    Integer reduce = transactions.stream()
        .map(t -> t.getValue())
        .reduce(0, Integer::max);

    System.out.println(reduce);
  }

  public void quiz_5_6_8() {
    List<Transaction> transactions = getTransactionData();

    transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::min)
        .ifPresent(System.out::println);

    Optional<Transaction> min = transactions.stream()
        .min(Comparator.comparing(Transaction::getValue));
  }

  public void quiz_5_4() {
    Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
        .limit(20)
        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
  }


  private List<Transaction> getTransactionData() {
    Trader raoul = new Trader("Roul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950));

    return transactions;
  }
}
