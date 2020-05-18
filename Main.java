import java.util.Scanner;
import java.util.Random;

public class Main {

public static void main(String args[]) 
{
	int answer;
	int [] Arrayinput = new int [9];
	int [] example = {0,1,2,3,4,5,6,7,8};
	int input = 0;
	Search sa = new Search();
	
	System.out.println("Enter '1' or '2': \n\n1: Generate Random Puzzle Array ");
	System.out.println("2: Enter a Specific Puzzle Array \n");
	
	Scanner sc = new Scanner(System.in);
	answer = sc.nextInt();
	
	Random ran = new Random();
	
	if(answer == 1)
	{
		int x = 0;
		// while(x < 1000)
		// {
			boolean test = true;
			
			while(test)
			{
				int valid = 0;
				for(int c = 0; c < example.length; c++)
				{
					int index = ran.nextInt(9);
					int index2 = ran.nextInt(9);
					
					int temp = example[index];
					example[index] = example[index2];
					example[index2] = temp;
				}
				
				for(int m = 0; m < example.length-1; m++)
				{
					if(example[m] > example[m+1])
						valid++;
				}
				
				if(valid % 2 == 0)				// If Array is Solvable Start Search
					test = false;
			}
			
			System.out.println("This is the shuffled Array: \n");
			
			for(int l = 0; l < example.length; l++)
			{
				System.out.print(example[l]);
				
				if(l != example.length-1)
					System.out.print(",");
			}
			
			
	/*************** GRAPH SEARCH *******************/
			System.out.println("\n\nGraph Search with Heuristic 1: \n");
			long startTime = System.nanoTime();
			System.out.print("\n\n");
			sa.Graph_Search(example,1 );
	
			long endTime = System.nanoTime();
			System.out.println("Took "+(endTime - startTime)/1000000 + " ms");
			
			System.out.println("\n\nGraph Search with Heuristic 2: \n");
			long startTime1 = System.nanoTime();
	
			sa.Graph_Search(example,2);
	
			long endTime1 = System.nanoTime();
			System.out.println("Took "+(endTime1 - startTime1)/1000000 + " ms"); 
			
	/***************** TREE SEARCH *******************/
			System.out.println("\n\nTree Search with Heuristic 1: \n");
			long startTime2 = System.nanoTime();
			sa.Tree_Search(example,1 );
	
			long endTime2 = System.nanoTime();
			System.out.println("Took "+(endTime2 - startTime2)/1000000 + " ms"); 
			
			System.out.println("\n\nTree Search with Heuristic 2: \n");
			long startTime3 = System.nanoTime();
			sa.Tree_Search(example,1 );
	
			long endTime3 = System.nanoTime();
			System.out.println("Took "+(endTime3 - startTime3)/1000000 + " ms"); 
			
			
		//	x++;
		//}
		
		System.out.println("This is x: " + x);
	}
	
	if(answer == 2)
	{
		boolean test = true;
		while(test)
		{
			int valid = 0;
			System.out.println("Please enter 9 Numbers to input into the Puzzle 0-8 One by one \n");
			
			for(int j = 0; j < Arrayinput.length; j++)
			{
				input = sc.nextInt();
				Arrayinput[j] = input;
			}
			
			for(int m = 0; m < example.length-1; m++)
			{
				if(example[m] > example[m+1])
					valid++;
			}
			
			if(valid % 2 == 0)				// If Array is Solvable Start Search
				test = false;
			else 
			{
				System.out.println("Error Please enter a Solvable Puzzle\n");
			}
		}
	
		
/*************** GRAPH SEARCH ********************/
		System.out.println("\n\nGraph Search with Heuristic 1: ");
		long startTime = System.nanoTime();

		sa.Graph_Search(Arrayinput,1);

		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime)/1000000 + " ms");
		
		System.out.println("\nGraph Search with Heuristic 2: \n");
		long startTime5 = System.nanoTime();
	
		sa.Graph_Search(Arrayinput,2);

		long endTime5 = System.nanoTime();
		System.out.println("Took "+(endTime5 - startTime5)/1000000 + " ms"); 
		
/***************** TREE SEARCH ********************/
		System.out.println("\n\nTree Search with Heuristic 1: \n");
		long startTime2 = System.nanoTime();

		sa.Tree_Search(Arrayinput,1 );

		long endTime2 = System.nanoTime();
		System.out.println("Took "+(endTime2 - startTime2)/1000000 + " ms"); 
		
		System.out.println("\n\nTree Search with Heuristic 2: \n");
		long startTime3 = System.nanoTime();
		sa.Tree_Search(Arrayinput,1 );

		long endTime3 = System.nanoTime();
		System.out.println("Took "+(endTime3 - startTime3)/1000000 + " ms"); 
		
	}
}

}

