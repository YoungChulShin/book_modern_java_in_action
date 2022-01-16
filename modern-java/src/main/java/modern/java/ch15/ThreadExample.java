package modern.java.ch15;

public class ThreadExample {

  public static void main(String[] args) throws InterruptedException {
    int x = 1337;
    Result result = new Result();

    Thread t1 = new Thread(() -> { result.left = f(x);});
    Thread t2 = new Thread(() -> { result.right = g(x);});
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(result.left + " " + result.right);
  }

  private static int f(int x) {
    System.out.println("f 시작");
    for (int i = 1; i < 100000000; i++) {
      x++;
    }
    System.out.println("f 종료");

    return x;
  }

  private static int g(int x) {
    System.out.println("g 시작");
    for (int i = 1; i < 100000000; i++) {
      x++;
    }
    System.out.println("g 종료");

    return x;
  }

  private static class Result {
    private int left;
    private int right;
  }
}
