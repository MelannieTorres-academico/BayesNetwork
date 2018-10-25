#include <iostream>
#include <fstream>
#include <string>
#include <string.h>
#include <stdio.h>

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
class Probabilities {

  private:
     string description;
     float value;


  public:
    Probabilities(){}

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


class Parser {
  public:
    Parser(){}

    void parser(){
      int numberOfProbabilities, numberOfQueries, pos;
      char *token;

      ifstream infile;
    	infile.open ("../Tests/Sprinkler,Rain,GrassWet.txt");
      string line;

      getline(infile, line);
      infile >> numberOfProbabilities;
      cout << numberOfProbabilities<<endl;
      string up_probabilities[numberOfProbabilities];
      Probabilities probabilities[numberOfProbabilities];

      for (int i=0; i<numberOfProbabilities; i++) {
        getline(infile, line);
        infile >> up_probabilities[i];
        pos = up_probabilities[i].find("=");

        probabilities[i].setDescription(up_probabilities[i].substr(0, pos));
        probabilities[i].setValue(stof(up_probabilities[i].substr(pos+1)));

        cout << probabilities[i].getDescription()<<" "<<probabilities[i].getValue()<<endl;
      }

      getline(infile, line);
      infile >> numberOfQueries;
      cout << numberOfQueries<<endl;
      string up_queries[numberOfQueries];
      Query queries[numberOfQueries];

      for (int i=0; i<numberOfQueries; i++) {
        getline(infile, line);
        infile >> up_queries[i];
        queries[i].setDescription(up_queries[i]);
        cout << queries[i].getDescription()<<endl;
      }
    	infile.close();
  }
};


int main ()
{
  Parser p;
  p.parser();

  return 0;
}
