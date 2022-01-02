package modern.java.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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

  public void pythagoras() {
    Stream<int[]> stream = IntStream.range(1, 100).boxed()
        .flatMap(a ->
            IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

    stream.limit(5)
        .forEach(t -> System.out.println(t[0]+", "+t[1]+", "+t[2]));
  }

  public void pythagoras2() {
    Stream<double[]> stream = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(1, 100)
            .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
            .filter(t -> t[2] % 1 == 0));

    stream.limit(5)
        .forEach(t -> System.out.println(t[0]+", "+t[1]+", "+t[2]));
  }

}
