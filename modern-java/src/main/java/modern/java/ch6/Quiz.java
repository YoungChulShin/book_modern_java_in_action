package modern.java.ch6;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Quiz {

  public void quiz_6_1() {
    List<Dish> menu = Ch6Helper.getMenu();

    // 문자열 연결 1
    String collect1 = menu.stream().map(Dish::getName).collect(Collectors.joining());

    // 문자열 연결 2
    String collect2 = menu.stream().map(Dish::getName)
        .collect(Collectors.reducing("", (a, b) -> a + b));

    // 문자열 연결 3
    menu.stream().collect(Collectors.reducing("", Dish::getName, (a, b) -> a + b));

  }
}
