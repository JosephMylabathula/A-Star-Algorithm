import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;

public class Search {
	
	public void Graph_Search(int [] current, int heuristic)
	{
		int limit = 0;
		int counter = 0;
		int i = 0;
		
		int Node_Cost = 1;
		
		int [] reset = {0,1,2,3,4,5,6,7,8};

		Node main = new Node(current, heuristic);
		PriorityQueue<Node> frontier = new PriorityQueue<>();
		
		ArrayList <Node> explored = new ArrayList<Node>();	
		
		frontier.add(main);
		
		while(limit < 25)
		{
			if(frontier.isEmpty())						// If Frontier is empty then return Failure
			{
				System.out.println("Could Not find Answer, here is the path we found");
				System.out.println("The Depth is: "+ main.getpathcost());
				System.out.println("The Search Cost is: " + Node_Cost);
				System.out.println("Here are the Array's Used for the answers child to parent: \n");
				print(main);
				
				return;
			}
			
			main = frontier.remove();
			
			if(heuristic == 1)
			{
				if(main.get_heuristic() == 0)				// If current array equals the goal state
				{
					System.out.println("Here is the Answer: ");
					System.out.println("The Depth is: "+ main.getpathcost());
					System.out.println("The Search Cost is: " + Node_Cost);
					System.out.println("Here are the Array's Used for the answers child to parent: \n");
					print(main);
					
					return;
				}
			}
			
			if(heuristic == 2)
			{
				if(main.get_heuristic2() == 0)				// If current array equals the goal state
				{
					System.out.println("Here is the Answer: ");
					System.out.println("The Depth is: "+ main.getpathcost());
					System.out.println("The Search Cost is: " + Node_Cost);
					System.out.println("Here are the Array's Used for the answers child to parent: \n");
					print(main);
					
					return;
				}
			}
			
			explored.add(main);					

			while(main.get_Array()[i] != 0)								// Find 0 Index in Array
				i++;
			
			counter = i;
			
			if(i != 0 && i != 1  && i!= 2)								// If 0 is not in the top row of the puzzle
			{
				int swap_index = -3;
				boolean add = true;
								
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic);	
				Node_Cost++;
				
				for(Node n: frontier)									// Check if Node is in Priority Queue
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				for(Node n: explored)				// Check if Node is in Array List
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				if (add == true)
					frontier.add(child);
				
				i = counter;											// Reset i
				
			}

			if(i != 0  && i != 3   && i!= 6)							// If 0 is not in the left column of the puzzle
			{
				int swap_index = -1;
				boolean add = true;
				
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic);
				Node_Cost++;
				
				for(Node n: frontier)				// Check if Node is in Priority Queue
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				for(Node n: explored)				// Check if Node is in Array List
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				if (add == true)										// If Node is not a duplicate add it
					frontier.add(child);
												
				i = counter;											// Reset i
			}
			
			if(i != 2  && i != 5   && i!= 8)							// If 0 is not in the Right column of the puzzle
			{
				int swap_index = 1;
				boolean add = true;
				
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic);	// Pass Temp array to create a new node
				Node_Cost++;
				
				for(Node n: frontier)				// Check if Node is in Priority Queue
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				for(Node n: explored)				// Check if Node is in Array List
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				if (add == true)					// If Node is Unique add to Priority Queue
					frontier.add(child);
												
				i = counter;											// Reset i
			}
			
			if(i != 6  && i != 7  && i!= 8)								// If 0 is not in the bottom column of the puzzle
			{
				int swap_index = 3;
				boolean add = true;
				
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic); // Pass Temp array to create a new node
				Node_Cost++;
				for(Node n: frontier)				// Check if Node is in Priority Queue
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				for(Node n: explored)				// Check if Node is in Array List
				{
					int check = 0;
					for(int m = 0; m < child.get_Array().length; m++)
					{
						if(child.get_Array()[m] == n.get_Array()[m])
						{
							check++;
						}
						
						if(check == 9)
							add = false;
					}
				}
				
				if (add == true)										// If Node is Unique add to Priority Queue
					frontier.add(child);
				
				i = counter;											// Reset i
				
			}
			
			i = 0;														// Reset i
			limit++;													// Increment Limit
			
			
			if(limit == 24)												// If limit Reached, print out Progress
			{
				System.out.println("Limit of 24 Reached, could not find definite Answer\n");
				System.out.println("Here is the Answer of what we found: ");
				
				for(int y = 0; y < main.get_Array().length; y++)
				{
					System.out.print(main.get_Array()[y]);
				}
				System.out.println("\nThe Depth is: "+ main.getpathcost());
				System.out.println("\nThe Search Cost is: " + Node_Cost);
				System.out.println("Here are the Array's Used for the answers child to parent : \n");
				
				print(main);
				
			}
			
			
		}
		
		
	}
	
	public void Tree_Search(int [] current, int heuristic)
	{
		int limit = 0;
		int counter = 0;
		int i = 0;
		int heuristic1 = 0;
		int Node_Cost = 1;
		int avg1,avg2,avg3 = 0;
		
		int [] reset = {0,1,2,3,4,5,6,7,8};

		Node main = new Node(current, heuristic);
		PriorityQueue<Node> frontier = new PriorityQueue<>();
		
		frontier.add(main);
		
		while(limit < 25)
		{
			if(frontier.isEmpty())						// If Frontier is empty then return Failure
			{
				System.out.println("Could Not find Answer, here is the path we found");
				System.out.println("The Depth is: "+ main.getpathcost());
				System.out.println("The Search Cost is: " + Node_Cost);
				System.out.println("Here are the Array's Used for the answers child to parent \n");
				print(main);
				
				return;
			}
			
			main = frontier.remove();
			
			if(heuristic == 1)
			{
				if(main.get_heuristic() == 0)				// If current array equals the goal state
				{
					System.out.println("Here is the Answer: ");
					System.out.println("The Depth is: "+ main.getpathcost());
					
					System.out.println("The Search Cost is: " + Node_Cost);
					System.out.println("Here are the Array's Used for the answers: \n");
					print(main);
					System.out.println("Here are the Array's Used for the answers child to parent: \n");
					
					print(main);
					return;
				}
			}
			
			if(heuristic == 2)
			{
				if(main.get_heuristic2() == 0)				// If current array equals the goal state
				{
					System.out.println("\n\nHere is the Answer: ");
					System.out.println("The Depth is: "+ main.getpathcost());
					System.out.println("The Search Cost is: " + Node_Cost);
					System.out.println("Here are the Array's Used for the answers child to parent: \n");
					print(main);
					
					return;
				}
			}	

			while(main.get_Array()[i] != 0)				// Find 0 Index in Array
				i++;
			
			counter = i;
			
			if(i != 0 && i != 1  && i!= 2)								// If 0 is not in the top row of the puzzle
			{
				int swap_index = -3;
								
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic);	
				Node_Cost++;
				frontier.add(child);									// Then Pass node into Priority Queue
				i = counter;											// Reset i
			}

			if(i != 0  && i != 3   && i!= 6)							// If 0 is not in the left column of the puzzle
			{
				int swap_index = -1;
				
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic);
				Node_Cost++;
				frontier.add(child);									// Then Pass node into Priority Queue
				i = counter;											// Reset i
			}
			
			if(i != 2  && i != 5   && i!= 8)							// If 0 is not in the Right column of the puzzle
			{
				int swap_index = 1;
				
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic);	// Pass Temp array to create a new node
				Node_Cost++;
				frontier.add(child);									// Then Pass node into Priority Queue
				i = counter;											// Reset i
			}
			
			if(i != 6  && i != 7  && i!= 8)								// If 0 is not in the bottom column of the puzzle
			{
				int swap_index = 3;
				
				Node child = new Node(swap(main.get_Array(), i, swap_index), main, heuristic); // Pass Temp array to create a new node
				Node_Cost++;
				frontier.add(child);									// Then Pass node into Priority Queue
				i = counter;											// Reset i
				
			}
			
			i = 0;														// Reset i
			limit++;													// Increment Limit
			
			if(limit == 24)												// If limit Reached, print out Progress
			{
				System.out.println("\nLimit of 24 Reached, could not find definite Answer");
				System.out.println("\nHere is the Answer of what we found: ");
				
				for(int y = 0; y < main.get_Array().length; y++)
				{
					System.out.print(main.get_Array()[y]);
				}
				System.out.println("\n\nThe Depth is: "+ main.getpathcost());
				System.out.println("\nThe Search Cost is: " + Node_Cost);
				System.out.println("Here are the Array's Used for the answers child to parent: \n");
				
				print(main);
			}
		}
		
		
	}
	
	
	public int [] swap(int [] arr, int index, int swap_index)
	{
		int [] copy_array = new int [9];
		copy_array = Arrays.copyOf(arr, 9);									// Copy Main to Copy Array
		
		copy_array[index] = copy_array[index+swap_index];
		copy_array[index+ swap_index] = 0;	
		
		return copy_array;
	}
	
	
	public void print(Node answer)											// Print Parent Node of Answer using Recursion
	{
		if(answer.getparent() == null)										// Base Case
			return;		
		
		for(int m = 0; m < answer.get_Array().length; m++)
			System.out.print(answer.get_Array()[m]);
		
		System.out.print("\n");
		
		print(answer.getparent());
			
	}
	
}
