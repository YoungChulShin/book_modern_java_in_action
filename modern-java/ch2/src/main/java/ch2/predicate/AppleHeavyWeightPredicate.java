package ch2.predicate;

import ch2.model.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

  @Override
  public boolean test(Apple apple) {
    return apple.getWeight() > 150;
  }
}
