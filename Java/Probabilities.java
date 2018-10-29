import java.lang.String;

class Probabilities {

  private String description;
  private float value;

  /*
  * Probabilities constructor
  */
  public Probabilities(String description, float value ){
    this.description = description;
    this.value = value;
  }

  /*
  * Retrieves the description
  */
  public String getDescription(){
    return description;
  }

  /*
  * Modifies the description
  */
  public float getValue(){
    return value;
  }
}
