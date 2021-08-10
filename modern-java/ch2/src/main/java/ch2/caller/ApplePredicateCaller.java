package ch2.caller;

import ch2.filter.AppleFilter;
import ch2.model.Apple;
import ch2.model.Color;
import ch2.predicate.ApplePredicate;
import java.util.ArrayList;
import java.util.List;

public class ApplePredicateCaller {

  public void filterApplesWithAnonymousClass() {
    List<Apple> inventory = new ArrayList<>();

    List<Apple> redApples = AppleFilter.filterApples(inventory, new ApplePredicate() {
      @Override
      public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor());
      }
    });
  }

  public void filterApplesWithLambda() {
    List<Apple> inventory = new ArrayList<>();

    List<Apple> redApples = AppleFilter.filterApples(
        inventory,
        (Apple apple) -> Color.RED.equals(apple.getColor()));
  }
}
