package ch2.caller;

import ch2.filter.GenericFilter;
import ch2.model.Apple;
import ch2.model.Color;
import java.util.ArrayList;
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
}
