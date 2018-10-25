import java.lang.String;

class Queries {

  private String description;
  private float value;


  public Queries(String description ){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

  public float getValue(){
    return value;
  }

  public void setValue(float value){
    this.value = value;
  }

}
