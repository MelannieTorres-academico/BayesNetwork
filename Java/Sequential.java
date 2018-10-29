import java.util.Scanner;
import java.lang.String;
import java.util.*;

/* To run:
*  javac *.java
*  java Sequential < ../Tests/Sprinkler,Rain,GrassWet.txt
*/

class Sequential {
  private Bayes bayes;

  /*
  * Retrieves the bayes object
  */
  public Bayes getBayes(){
    return this.bayes;
  }

  /*
  * Modifies the Bayes object
  */
  public void setBayes( Bayes bayes){
    this.bayes = bayes;
  }

  /*
  * Parses the input given (see folder Tests with input examples)
  */
  public void parse(){
    Scanner input = new Scanner(System.in);

    //nodes
    String up_nodes = input.nextLine(); //unparsed nodes
    String[] nodes = up_nodes.split(","); //parsed nodes

    //probabilites
    int numberOfProbabilities = input.nextInt();
    input.nextLine(); //clear buffer

    String up_probability = new String(); //unparsed probabilities
    List<Probabilities> probabilities = new ArrayList<Probabilities>();

    for(int i=0; i<numberOfProbabilities; i++){
      up_probability = input.nextLine();
      String[] aux_probabilities = up_probability.split("=");

      String description = aux_probabilities[0];
      float value = Float.parseFloat(aux_probabilities[1]);
      probabilities.add(new Probabilities(description, value));  //parsed probabilities
    }

    //Queries
    int numberOfQueries = input.nextInt();
    input.nextLine(); //clear buffer

    String up_query = new String(); //unparsed queries
    List<Queries> queries = new ArrayList<Queries>();

    for(int i=0; i<numberOfQueries; i++){
      up_query = input.nextLine();
      queries.add(new Queries(up_query)); //parsed queries
    }

    //instanciate Bayes
    Bayes bayes = new Bayes(probabilities, queries, nodes);
    setBayes(bayes);
  }


  public static void main(String[] args) {
    Sequential sequential = new Sequential();
    sequential.parse();
    Bayes bayes = sequential.getBayes();

    //only for testing purposes

    bayes.printProbabilities();
    bayes.printQueries();
    System.out.println("---------------");
    bayes.fillTable();
    bayes.printProbabilities();
  }

}
