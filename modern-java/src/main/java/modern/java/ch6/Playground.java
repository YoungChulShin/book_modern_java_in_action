package modern.java.ch6;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Playground {

  public void testCounting() {
    List<Dish> menu = Ch6Helper.getMenu();

    Long collect = menu.stream().collect(Collectors.counting());
    Long collect2 = menu.stream().count();
  }

  public void testMax() {
    List<Dish> menu = Ch6Helper.getMenu();

    menu.stream().max(Comparator.comparingInt(Dish::getCalories));
  }

  public void testSumInt() {
    List<Dish> menu = Ch6Helper.getMenu();

    Integer collect = menu.stream()
        .collect(Collectors.summingInt(Dish::getCalories));
    int sum = menu.stream().mapToInt(Dish::getCalories).sum();

    Integer collect1 = menu.stream().collect(
        Collectors.reducing(0, Dish::getCalories, (a, b) -> a + b));

    Integer reduce = menu.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b);

    Optional<Integer> reduce1 = menu.stream().map(Dish::getCalories).reduce((a, b) -> a + b);
  }

  public void testAvgCalories() {
    List<Dish> menu = Ch6Helper.getMenu();

    menu.stream()
        .collect(Collectors.averagingInt(Dish::getCalories));
  }

  public void testJoin() {
    List<Dish> menu = Ch6Helper.getMenu();

    String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
    System.out.println(collect);
  }
}
