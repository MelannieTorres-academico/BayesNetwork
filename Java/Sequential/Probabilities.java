import java.lang.String;

class Probabilities {

  private String description;
  private float value;


  public Probabilities(String description, float value ){
    this.description = description;
    this.value = value;
  }

  public String getDescription(){
    return description;
  }

  public float getValue(){
    return value;
  }
}
