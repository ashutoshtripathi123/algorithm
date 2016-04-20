package algorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvaluationParser {
	void evaluationFileParser() throws FileNotFoundException
	{
		//System.out.println("Under Construction");
		TrainingParser checklist;
		Scanner scanner2 = new Scanner(new File("TNH_Evaluation_Data.csv"));
		Scanner scanner3 = new Scanner(scanner2.nextLine());
		StringBuilder tempStarter= new StringBuilder("");
		String line;
		//scanner2.nextLine();
		List<String> str1 = new ArrayList<String>();
		List<Float> sensorVal = new ArrayList<Float>();
		int i=0, avgCount=0;
		float sum=0;
        while(scanner2.hasNextLine() )
        {
			line = scanner2.nextLine();
			//System.out.println(line);
			scanner3 = new Scanner(line);
			scanner3.useDelimiter(",");
			//System.out.println(scanner3.next());
			scanner3.next();
			float val = Float.parseFloat(scanner3.next());
			sensorVal.add(val);
			sum=sum+val;
        	++avgCount;
        	if(avgCount == 10)
        	{
        		sum=sum/10;
        		if(sum < 33.3)
        		{
        			tempStarter.append("a");
        		}
        		else if(sum < 66.6)
        		{
        			tempStarter.append("b");
        		}
        		else
        		{
        			tempStarter.append("c");
        		}
        		avgCount=0;
        		sum=0;
        	}

			++i;
        }
		//System.out.println(sensorVal);
		//System.out.println(tempStarter);
		System.out.println(tempStarter.length());
		System.out.println(tempStarter);
        
        //Start from index 0, check 0 and 5, if they are a and c, then it means its a start up, else
		// start from index 5+1
		int counter=0;
		while((counter+5) < tempStarter.length())
		{
			if(tempStarter.charAt(counter) == 'a' && tempStarter.charAt(counter+5) == 'c')
			{
				System.out.println("STARTUP DETECTED !!!" + counter);
			}
			counter=counter+5;
		}
		
        scanner3.close();
		scanner2.close();
	}

}
