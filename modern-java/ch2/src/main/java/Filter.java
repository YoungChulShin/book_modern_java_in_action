import java.util.ArrayList;
import java.util.List;
import model.Apple;
import model.Color;
import predicate.ApplePredicate;

public class Filter {

  public static List<Apple> filterGreeApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (Color.GREEN.equals(apple.getColor())) {
        result.add(apple);
      }
    }

    return result;
  }

  public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (color.equals(apple.getColor())) {
        result.add(apple);
      }
    }

    return result;
  }

  public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }

    return result;
  }

}
