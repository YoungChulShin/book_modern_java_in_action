package modern.java.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}
