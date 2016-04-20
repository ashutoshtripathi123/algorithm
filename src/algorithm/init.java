package algorithm;

import java.io.FileNotFoundException;
/***************** Starting Point of the Program *********************/
public class init {
	public static void main(String args[]) throws FileNotFoundException  {
		TrainingParser objTrainParser = new TrainingParser();
		EvaluationParser objEvalParser = new EvaluationParser();
		objTrainParser.trainingFileParser();
		objEvalParser.evaluationFileParser();
   }
}
