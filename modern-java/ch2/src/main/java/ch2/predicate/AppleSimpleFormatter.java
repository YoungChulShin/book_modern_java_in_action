package ch2.predicate;

import ch2.model.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

  @Override
  public String format(Apple apple) {
    return "An apple of " + apple.getWeight() + "g";
  }
}
