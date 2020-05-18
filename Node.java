/**
 *  Joseph Mylabathula
 *
 */

public class Node implements Comparable<Node> {

	private int [] goal = {0,1,2,3,4,5,6,7,8};
	private int [] current = new int [9];
	private Node parent;
	private int heuristic1, heuristic2, decide;
	private int F_of_n;
	private int pathcost;
	
	public Node(int [] current, int decide)
	{
		this.current = current;
		this.heuristic1 = get_heuristic();
		this.heuristic2 = get_heuristic2();
		this.parent = null;
		this.decide = decide;
		pathcost = 0;
		this.F_of_n = get_F_of_N();
	}
	
	public Node(int [] current, Node parent, int decide) 
	{
		this.current = current;
		this.heuristic1 = get_heuristic();
		this.heuristic2 = get_heuristic2();
		this.parent = parent;
		this.decide = decide;
		this.pathcost = parent.getpathcost() + 1;
		this.F_of_n = get_F_of_N();
	}
	
	public int get_F_of_N()
	{
		if(getdecide() == 1)
			F_of_n = pathcost + heuristic1;
		
		if(getdecide() == 2)
			F_of_n = pathcost + heuristic2;
		
		return F_of_n;
	}
	
	public int[] getCurrent() {
		return current;
	}

	public void setCurrent(int[] current) {
		this.current = current;
	}

	public int[] get_Array()
	{
		return current;
	}
	
	public int get_heuristic()
	{
		heuristic1 = 0;
		for(int i = 0; i < goal.length; i++)
		{
			if(current[i] == 0)				// Do not count X during heuristic
				continue;
			
			if(current[i] != goal[i])
				heuristic1++; 
		}
		
		return heuristic1; 
	}
	
	public int get_heuristic2()
	{
		int arr[][] = new int[3][3];
		int x = 0;
		int answer = 0;
		
		for(int m = 0; m <= 2; m++)
		{
			for(int n = 0; n <= 2; n++)
			{
				arr[m][n] = current[x];
				x++;
			}
		}
		
		while(answer < 9)
		{
			for(int m = 0; m <= 2; m++)
			{
				for(int n = 0; n <= 2; n++)
				{
					if(arr[m][n] == answer)
					{
						heuristic2 += (Math.abs((m - (answer/3))) + Math.abs(n - (answer % 3)));
					}
				}
			}
			answer++;
		}
		
		return heuristic2;
	}
	
	
	public int getpathcost()
	{
		 return pathcost;
	}
	
	public Node getparent()
	{
		return parent;
	}
	
	public int getdecide()
	{
		return decide;
	}

	@Override
	public int compareTo(Node x) {
		
		if(get_F_of_N() > x.get_F_of_N())
			return 1;
		
		else if(get_F_of_N() < x.get_F_of_N())
			return -1;
		
		return 0;
	}
	
}
