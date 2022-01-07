package modern.java.ch7;

public class Main {

  public static void main(String[] args) {
    PlayGround playGround = new PlayGround();
//    System.out.println(playGround.sequentialSum(10));
//    System.out.println(playGround.parallelSum(10));

    // System.out.println(Runtime.getRuntime().availableProcessors());
    playGround.sideEffectSum(10_000_000L);
    playGround.sideEffectParallelSum(10_000_000L);
  }

}
