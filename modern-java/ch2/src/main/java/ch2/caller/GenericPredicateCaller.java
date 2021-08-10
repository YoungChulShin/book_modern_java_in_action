package ch2.caller;

import ch2.filter.GenericFilter;
import ch2.model.Apple;
import ch2.model.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericPredicateCaller {

  public void filterRedApples() {
    List<Apple> apples = new ArrayList<>();

    List<Apple> result = GenericFilter
        .filter(apples, (Apple apple) -> Color.RED.equals(apple.getColor()));
  }

  public void filterEvenNumbers() {
    List<Integer> numbers = new ArrayList<>();

    List<Integer> result = GenericFilter.filter(numbers, (Integer i) -> i % 2 == 0);
  }

  public void sortApples() {
    List<Apple> apples = new ArrayList<>();

    apples.sort(new Comparator<Apple>() {
      @Override
      public int compare(Apple o1, Apple o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
      }
    });
  }

  public void sortApplesWithLamba() {
    List<Apple> apples = new ArrayList<>();

    apples.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
  }

  public void runnableThread() {
    Thread thread = new Thread(() -> System.out.println("Hello"));
  }
}
