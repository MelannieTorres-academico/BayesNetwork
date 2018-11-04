import java.lang.String;
import java.util.*;



class Bayes {
  private List<Probabilities> probabilites;
  private List<Queries> queries;


  /*
  * Bayes default constructor
  */
  public Bayes() {}

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
  * Retrieves all the probabilities
  */
  public void setProbabilites(List<Probabilities> probabilites) {
    this.probabilites = probabilites;
  }

  /*
  * Retrieves all the queries
  */
  public void setQueries(List<Queries> queries) {
    this.queries = queries;
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

    setQueries(queries);
    setProbabilites(probabilities);
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

  /**
   * Enumerates the probabilities according to the Bayes network algorithm
   * @param String Array probabilities
   */
  void enumerate(String probabilities[]){
     int length = (int)Math.pow(2, probabilities.length);
     String new_probabilities[][] = new String[length][probabilities.length];

     int mid = (length-0)/2;
     halfTrueHalfFalse(probabilities, "+", 0, mid, 0, new_probabilities);
     halfTrueHalfFalse(probabilities, "-", mid, length, 0, new_probabilities);
     printMatrix(new_probabilities);
  }

  /**
   * Prints the given matrix
   * @param String[][] matrix
   */

  void printMatrix(String[][] matrix){
    int i, j;
    for(i = 0; i < matrix.length; i++){
      for(j = 0; j < matrix[0].length; j++){
        System.out.print(matrix[i][j].toString()+" ");
      }
      System.out.println(" ");
    }
  }


  /**
   * Fills the 2D array new probabilities with all possible combinations of signs among the elements of the prob array
   * @param String Array prob, String sign, int start, int end, int element, String 2D array new_probabilities
   */
  void halfTrueHalfFalse(String [] prob, String sign, int start, int end, int element, String [][] new_probabilities){
    if(element < prob.length){ //validation
      for (int i = start; i < end; i++){
        new_probabilities[i][element] = sign + prob[element];
      }
      //recursive calls
      int mid = start + ((end-start)/2);
      halfTrueHalfFalse(prob, "+", start, mid, element+1, new_probabilities);
      halfTrueHalfFalse(prob, "-", mid, end, element+1, new_probabilities);
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
