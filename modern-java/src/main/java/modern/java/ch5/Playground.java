package modern.java.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import modern.java.ch5.Dish.Type;

public class Playground {

  public boolean equalTest() {
    Dish dish = new Dish("a", false, 100, Type.MEAT);
    Dish dish2 = new Dish("a", false, 100, Type.MEAT);

    return dish.equals(dish2);
  }

  public List<Dish> distinctTest() {
    Dish dish = new Dish("a", false, 100, Type.MEAT);
    Dish dish2 = new Dish("a", false, 100, Type.MEAT);

    List<Dish> dishes = Arrays.asList(dish, dish2);

    return dishes.stream().distinct().collect(Collectors.toList());
  }
}
