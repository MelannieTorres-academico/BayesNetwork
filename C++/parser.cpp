#include <iostream>
#include <fstream>
#include <list>

using namespace std;


class Query {
  private:
    string description;
    float value;
  public:
    Query(){}

    void setDescription(string d){
      description = d;
    }

    void setValue(float v){
      value = v;
    }

    string getDescription(){
      return description;
    }

    float getValue(){
      return value;
    }
};

class Probability {

  private:
     string description;
     float value;


  public:
    Probability(){}

    string getDescription(){
      return description;
    }

    float getValue(){
      return value;
    }

    void setDescription(string d){
      description = d;
    }

    void setValue(float v){
      value = v;
    }
};



class Main {
  private:
    list<Query> queries;
    list<Probability> probabilites;

  public:
    Main(){probabilites.begin(),queries.begin();}

    list<Probability> getProbabilites(){
      return probabilites;
    }

    list<Query> getQueries(){
      return queries;
    }

    /*
    * Parses the input given (see folder Tests with input examples)
    */
    void parse(){
      int numberOfProbabilities, numberOfQueries, pos;

      ifstream infile;
    	infile.open ("../Tests/Sprinkler,Rain,GrassWet.txt");
      string line;

      getline(infile, line);
      infile >> numberOfProbabilities;
      cout << numberOfProbabilities<<endl;
      string up_probabilities[numberOfProbabilities];
      Probability aux_probabilities;

      for (int i=0; i<numberOfProbabilities; i++) {
        getline(infile, line);
        infile >> up_probabilities[i];
        pos = up_probabilities[i].find("=");

        aux_probabilities.setDescription(up_probabilities[i].substr(0, pos));
        aux_probabilities.setValue(stof(up_probabilities[i].substr(pos+1)));
        probabilites.push_back(aux_probabilities);
      }

      getline(infile, line);
      infile >> numberOfQueries;
      cout << numberOfQueries<<endl;
      string up_queries[numberOfQueries];
      Query aux_queries;

      for (int i=0; i<numberOfQueries; i++) {
        getline(infile, line);
        infile >> up_queries[i];
        aux_queries.setDescription(up_queries[i]);
        queries.push_back(aux_queries);
      }
    	infile.close();
  }

  void fill_table(){
    list<Probability> probabilites_copy = probabilites;
    Probability aux_probabilities;
    string description;
    float value;


    for (auto v : probabilites_copy){
        description = v.getDescription();
        value = 1.0 - v.getValue();
        aux_probabilities.setValue(value);
        description.at(0)=(v.getDescription().at(0)=='+')?'-':'+';
        aux_probabilities.setDescription(description);
        probabilites.push_back(aux_probabilities);
    }
  }
};



int main ()
{
  Main p;
  p.parse();
  p.fill_table();
  for (auto v : p.getProbabilites()){
    cout<<v.getDescription()<<" "<<v.getValue()<<endl;
  }
  return 0;
}
