package ch2.predicate;

import ch2.model.Apple;
import ch2.model.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

  @Override
  public boolean test(Apple apple) {
    return apple.getColor().equals(Color.GREEN);
  }
}
