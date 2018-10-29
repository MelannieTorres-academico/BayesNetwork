import java.lang.String;
import java.util.*;



class Bayes {

  private List<Probabilities> probabilites;
  private List<Queries> queries;

  /*
  * Bayes constructor
  */
  public Bayes(List<Probabilities> probabilites, List<Queries> queries, String[] nodes ){
    this.probabilites = probabilites;
    this.queries = queries;
  }

  /*
  * Retrieves all the probabilities
  */
  public List<Probabilities> getProbabilites() {
    return probabilites;
  }

  /*
  * Retrieves all the queries
  */
  public List<Queries> getQueries() {
    return queries;
  }


  /*
  * Writes to the console all the probabilities in the CPT table
  */
  void printProbabilities() {
    System.out.println("PROBABILITIES: ");
    List<Probabilities> probabilites = this.getProbabilites();
    for(int i = 0; i < probabilites.size(); i++){
      System.out.println(i+": "+probabilites.get(i).getDescription()+" "+probabilites.get(i).getValue());
    }
  }

  /*
  * Writes to the console all the queries the user asked
  */
  void printQueries () {
    System.out.println("QUERIES: ");
    List<Queries> queries = this.getQueries();
    for(int i = 0; i < queries.size(); i++){
      System.out.println(i+": "+queries.get(i).getDescription()+" "+queries.get(i).getValue());
    }
  }

  /*
  * Completes the CPT table with the missing values
  */
  void fillTable () {
    Probabilities aux_probability;
    String description;
    float value;
    StringBuilder aux_description;

    List<Probabilities> copy_probabilities = new ArrayList<Probabilities>(probabilites);

    for(Probabilities probability : copy_probabilities) {

      aux_description = new StringBuilder(probability.getDescription());
      aux_description.setCharAt(0,(aux_description.charAt(0) == '+') ? '-' : '+');
      description = new String(aux_description.toString());

      value = (float)1.0 - probability.getValue();

      aux_probability = new Probabilities(description, value);

      if(!probabilites.contains(aux_probability)){
        probabilites.add(aux_probability);
      }
    }
  }

}
