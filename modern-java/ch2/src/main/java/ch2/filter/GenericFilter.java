package ch2.filter;

import ch2.predicate.Predicate;
import java.util.ArrayList;
import java.util.List;

public class GenericFilter {

  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> result = new ArrayList<>();
    for (T e : list) {
      if (p.test(e)) {
        result.add(e);
      }
    }

    return result;
  }
}
