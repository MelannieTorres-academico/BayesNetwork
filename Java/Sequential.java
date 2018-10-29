import java.util.Scanner;
import java.lang.String;
import java.util.*;

/* To run:
*  javac *.java
*  java Sequential < ../Tests/Sprinkler,Rain,GrassWet.txt
*/

class Sequential {

  public static void main(String[] args) {
    Bayes bayes = new Bayes();
    bayes.parse();
    //only for testing purposes

    bayes.printProbabilities();
    bayes.printQueries();
    System.out.println("---------------");
    bayes.fillTable();
    bayes.printProbabilities();
  }

}
