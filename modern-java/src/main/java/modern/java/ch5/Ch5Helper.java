package modern.java.ch5;

import java.util.Arrays;
import java.util.List;
import modern.java.ch4.Dish;
import modern.java.ch4.Dish.Type;

public class Ch5Helper {

  public static List<modern.java.ch4.Dish> getMenu() {
    return Arrays.asList(
        new modern.java.ch4.Dish("port", false, 800, Type.MEAT),

        new modern.java.ch4.Dish("beef", false, 700, Type.MEAT),
        new modern.java.ch4.Dish("chicken", false, 400, Type.MEAT),
        new modern.java.ch4.Dish("french fries", true, 530, Type.OTHER),
        new modern.java.ch4.Dish("rice", true, 350, Type.OTHER),
        new modern.java.ch4.Dish("season fruit", true, 120, Type.OTHER),
        new modern.java.ch4.Dish("pizza", true, 550, Type.OTHER),
        new modern.java.ch4.Dish("prawns", false, 300, Type.FISH),
        new Dish("salmon", false, 450, Type.FISH)
    );
  }
}
