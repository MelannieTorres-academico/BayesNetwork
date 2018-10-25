import java.util.Scanner;
import java.lang.String;

/* To run:
*  javac *.java
*  java Secuential < ../Tests/Sprinkler,Rain,GrassWet.txt
*/

class Secuential {
  private Bayes bayes;

  public Bayes getBayes(){
    return this.bayes;
  }

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

    String[] up_probabilities = new String [numberOfProbabilities]; //unparsed probabilities
    Probabilities probabilities[] = new Probabilities[numberOfProbabilities];

    for(int i=0; i<numberOfProbabilities; i++){
      up_probabilities[i]=input.nextLine();
      String[] aux_probabilities = up_probabilities[i].split("=");

      String description = aux_probabilities[0];
      float value = Float.parseFloat(aux_probabilities[1]);
      probabilities[i] = new Probabilities(description, value);  //parsed probabilities
    }

    //Queries
    int numberOfQueries = input.nextInt();
    input.nextLine(); //clear buffer

    String[] up_queries = new String [numberOfQueries]; //unparsed queries
    Queries queries[] = new Queries[numberOfQueries];

    for(int i=0; i<numberOfQueries; i++){
      up_queries[i] = input.nextLine();
      queries[i] = new Queries(up_queries[i]); //parsed queries
    }

    //instanciate Bayes
    Bayes bayes = new Bayes(probabilities, queries, nodes);
    setBayes(bayes);
  }


  public static void main(String[] args) {
    Secuential sequential = new Secuential();
    sequential.parse();
    Bayes bayes = sequential.getBayes();

    //only for testing purposes
    bayes.printProbabilities();
    bayes.printQueries();
  }

}
