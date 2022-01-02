package modern.java.ch5;

import java.util.Objects;

public class Dish {

  private final String name;
  private final boolean vegeterian;
  private final int calories;
  private final Type type;

  public Dish(String name, boolean vegeterian, int calories, Type type) {
    this.name = name;
    this.vegeterian = vegeterian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegeterian() {
    return vegeterian;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || o.getClass() != Dish.class) {
      return false;
    }

    Dish that = (Dish)o;
    return name.equals(that.name) &&
        vegeterian == that.vegeterian &&
        calories == that.calories &&
        type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, vegeterian, calories, type);
  }

  public enum Type { MEAT, FISH, OTHER }
}
