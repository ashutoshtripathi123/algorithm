package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainingParser {
	List<String> startUps = new ArrayList<String>();
	List<String> shutDowns = new ArrayList<String>();
	void trainingFileParser () throws FileNotFoundException
	{
		//List<String> startUps = new ArrayList<String>();
		//List<String> shutDowns = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("TNH_Training_Data.csv"));
         
        scanner.useDelimiter(",");
         
        int i=0, avgCount=0;
        float sum=0;
        StringBuilder tempStarter= new StringBuilder("");
        while (scanner.hasNext() && (i !=60)) 
        {
        	sum=Float.parseFloat(scanner.next())+sum;
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
        	if(i==60)
        	{
        		scanner.nextLine();
        		i=0;
        		sum=0;
        		avgCount=0;
        		char firstCharacter = tempStarter.charAt(0);
        		char lastCharacter = tempStarter.charAt(5);
        		
        		if(firstCharacter == 'c' && lastCharacter == 'a')
        		{
        			//System.out.println(tempStarter);
        			//System.out.print("\n");
        			shutDowns.add(new String(tempStarter));
        		}
        		else if(firstCharacter == 'a' && lastCharacter == 'c')
        		{
        			//System.out.println(tempStarter);
        			//System.out.print("\n");
        			startUps.add(new String(tempStarter));
        		}

        		firstCharacter='\0';
        		lastCharacter='\0';
        		tempStarter = new StringBuilder("");
        	}
        }
           
        System.out.println("startUps are: " + startUps);
        System.out.println("shutDowns are: " + shutDowns);

        /* Not reqd for Now. it will come in evaluation parser
         * for(int j=0;j<startUps.size();j++)
        {
        	if("cbaaaa".equals(startUps.get(j)))
        	{
        		System.out.println("TRUE :: " + (j+1));
        	}
        }
        */

        scanner.close();
	  }
	}
