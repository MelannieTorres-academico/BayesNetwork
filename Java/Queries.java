import java.lang.String;

class Queries {

  private String description;
  private float value;

  /*
  * Queries constructor
  */
  public Queries(String description){
    this.description = description;
  }

  /*
  * Retrieves the description
  */
  public String getDescription(){
    return description;
  }

  /*
  * Retrieves the value
  */
  public float getValue(){
    return value;
  }

  /*
  * Modifies the value
  */
  public void setValue(float value){
    this.value = value;
  }

  /*
  * RModifies the description
  */
  public void setDescription(String description){
    this.description = description;
  }

}
