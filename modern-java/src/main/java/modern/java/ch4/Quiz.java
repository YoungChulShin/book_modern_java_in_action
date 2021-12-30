package modern.java.ch4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {

  public void quiz_4_1_problem() {
    List<String> highCaloricDishes = new ArrayList<>();
    List<Dish> menu = Ch4Helper.getMenu();
    Iterator<Dish> iterator = menu.iterator();
    while (iterator.hasNext()) {
      Dish dish = iterator.next();
      if (dish.getCalories() > 300) {
        highCaloricDishes.add(dish.getName());
      }
    }
  }

  public void quiz_4_1_solve() {
    List<Dish> menu = Ch4Helper.getMenu();
    List<String> highCaloricDishes = menu.stream()
        .filter(dish -> dish.getCalories() > 300)
        .map(Dish::getName)
        .collect(Collectors.toList());
  }

  public void test_stream_sequence() {
    List<Dish> menu = Ch4Helper.getMenu();

    List<String> names = menu.stream()
        .filter(dish -> {
          System.out.println("filtering:" + dish.getName());
          return dish.getCalories() > 300;
        })
        .map(dish -> {
          System.out.println("mapping:" + dish.getName());
          return dish.getName();
        })
        .limit(3)
        .collect(Collectors.toList());
  }
}
