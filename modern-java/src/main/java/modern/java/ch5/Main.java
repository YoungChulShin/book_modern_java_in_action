package modern.java.ch5;

public class Main {

  public static void main(String[] args) {
    Playground playground = new Playground();

    System.out.println("Equal test: " + playground.equalTest());
    System.out.println("Distinct size: " + playground.distinctTest().size());

    Quiz quiz = new Quiz();
    quiz.quiz_5_2_3_solve();
  }
}
