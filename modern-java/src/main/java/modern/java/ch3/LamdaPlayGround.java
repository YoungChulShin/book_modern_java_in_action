package modern.java.ch3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LamdaPlayGround {

  public void test1() {

    Runnable r1 = () -> System.out.println("Hello World");
    r1.run();

    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello World2");
      }
    };
    r2.run();
  }

  public void test2() {
    LamdaPlayGround.process(new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello World3");
      }
    });

    LamdaPlayGround.process(() -> System.out.println("Hello World4"));
  }

  public String processFile() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
      return br.readLine();
    }
  }
  public static void process(Runnable r) {
    r.run();
  }

}
