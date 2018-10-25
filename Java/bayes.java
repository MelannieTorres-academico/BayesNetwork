import java.lang.String;


class Bayes {

  private Probabilities[] probabilites;
  private Queries[] queries;
  private String[] nodes;


  public Bayes(Probabilities[] probabilites, Queries[] queries, String[] nodes ){
    this.probabilites = probabilites;
    this.queries = queries;
    this.nodes = nodes;
  }

  public Probabilities[] getProbabilites(){
    return probabilites;
  }

  public Queries[] getQueries(){
    return queries;
  }

  public String[] getNodes(){
    return nodes;
  }


  void printProbabilities(){
    System.out.println("PROBABILITIES: ");

    Probabilities[] probabilites=this.getProbabilites();
    for(int i = 0; i<probabilites.length; i++){
      System.out.println(i+": "+probabilites[i].getDescription()+" "+probabilites[i].getValue());
    }
  }

  void printQueries(){
    System.out.println("QUERIES: ");

    Queries[] queries=this.getQueries();
    for(int i = 0; i<queries.length; i++){
      System.out.println(i+": "+queries[i].getDescription()+" "+queries[i].getValue());
    }
  }


}
