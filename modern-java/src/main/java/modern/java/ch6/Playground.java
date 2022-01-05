package modern.java.ch6;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import modern.java.ch6.Dish.Type;

public class Playground {

  public void testCounting() {
    List<Dish> menu = Ch6Helper.getMenu();

    Long collect = menu.stream().collect(Collectors.counting());
    Long collect2 = menu.stream().count();
  }

  public void testMax() {
    List<Dish> menu = Ch6Helper.getMenu();

    menu.stream().max(comparingInt(Dish::getCalories));
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

  public void testGrouping() {
    List<Dish> menu = Ch6Helper.getMenu();

    Map<Type, List<Dish>> collect = menu.stream()
        .collect(groupingBy(Dish::getType));
  }

  public void testGrouping2() {
    List<Dish> menu = Ch6Helper.getMenu();

    Map<CaloricLevel, List<Dish>> collect = menu.stream()
        .collect(groupingBy(dish -> {
          if (dish.getCalories() <= 400)
            return CaloricLevel.DIET;
          else if (dish.getCalories() <= 700)
            return CaloricLevel.NORMAL;
          else
            return CaloricLevel.FAT;
        }));
  }

  public void testGrouping3() {
    List<Dish> menu = Ch6Helper.getMenu();

    Map<Type, List<Dish>> collect = menu.stream()
        .collect(groupingBy(
            Dish::getType,
            filtering(x -> x.getCalories() > 500, toList())
        ));
  }

  public void testTwoDepthGrouping() {
    List<Dish> menu = Ch6Helper.getMenu();

    Map<Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream()
        .collect(
            groupingBy(
                Dish::getType,
                groupingBy(dish -> {
                  if (dish.getCalories() <= 400)
                    return CaloricLevel.DIET;
                  else if (dish.getCalories() <= 700)
                    return CaloricLevel.NORMAL;
                  else
                    return CaloricLevel.FAT;
                })
            )
        );
  }

  // 타입별 제일 칼로리 높은 음식 계산
  // Map<Type, Dish>
  public void testGrouping4() {
    List<Dish> menu = Ch6Helper.getMenu();

    Map<Type, List<Dish>> collect = menu.stream()
        .collect(groupingBy(x -> x.getType()));

    Map<Type, Optional<Dish>> collect1 = menu.stream()
        .collect(groupingBy(Dish::getType,
            maxBy(comparingInt(Dish::getCalories))));

    Map<Type, Dish> collect2 = menu.stream()
        .collect(groupingBy(Dish::getType,
            collectingAndThen(
                maxBy(comparingInt(Dish::getCalories)),
                Optional::get)));

    menu.stream()
        .collect(Collectors.toMap(Dish::getType, Function.identity(),
            BinaryOperator.maxBy(comparingInt(Dish::getCalories))));
  }

  public enum CaloricLevel { DIET, NORMAL, FAT }
}
