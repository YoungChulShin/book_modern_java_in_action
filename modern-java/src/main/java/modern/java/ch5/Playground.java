package modern.java.ch5;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
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

  public void generateStream() {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    Stream<Integer> stream = integers.stream();

    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

    IntStream intStream = IntStream.rangeClosed(1, 5);
    Stream<Integer> boxed = IntStream.rangeClosed(1, 5).boxed();

    Stream.empty();

    Stream<String> stringStream = Stream.ofNullable("4444");
  }

  public void infiniteStream() {
//    Stream.iterate(0, n -> n + 2)
//        .limit(10)
//        .forEach(System.out::println);

    // 언박싱이 없도록
    IntStream.iterate(0, n -> n + 2)
        .limit(10)
        .forEach(System.out::println);
  }

  public void infiniteStream2() {
    IntSupplier fib = new IntSupplier() {
      private int previous = 0 ;
      private int current = 1;

      @Override
      public int getAsInt() {
        int oldPrevious = this.previous;
        int nexValue = this.previous + this.current;
        this.previous = this.current;
        this.current = nexValue;
        return oldPrevious;
      }
    };

    IntStream.generate(fib)
        .limit(10)
        .forEach(System.out::println);
  }
}
