import java.util.ArrayList;
import java.util.List;

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


}
