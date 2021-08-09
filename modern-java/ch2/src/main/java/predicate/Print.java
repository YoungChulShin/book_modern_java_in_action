package predicate;

import java.util.List;
import model.Apple;

public class Print {

  public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
    for (Apple apple : inventory) {
      String output = formatter.format(apple);
      System.out.println(output);
    }
  }

}
