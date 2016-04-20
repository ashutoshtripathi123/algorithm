package algorithm;
//import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

public class init {
	public static void main(String args[]) throws FileNotFoundException  {
		TrainingParser objTrainParser = new TrainingParser();
		EvaluationParser objEvalParser = new EvaluationParser();
		objTrainParser.trainingFileParser();
		objEvalParser.evaluationFileParser();
   }
}
