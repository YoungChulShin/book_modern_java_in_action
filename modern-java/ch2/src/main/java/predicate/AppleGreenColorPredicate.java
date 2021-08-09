package predicate;

import model.Apple;
import model.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

  @Override
  public boolean test(Apple apple) {
    return apple.getColor().equals(Color.GREEN);
  }
}
