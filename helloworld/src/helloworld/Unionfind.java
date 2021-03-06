package helloworld;

public class Unionfind {

	int id[];
	
	public Unionfind(int no)
	{
		id = new int[no];
		for(int i=0;i<no;i++)
			{
			id[i]=i;
			}
	}
	public boolean connected(int x, int y)
	{
		if(id[x]==id[y]) return true;
		return false;
	}
	
	public void union(int x, int y)
	{
		//int key = (id[x]<id[y])? id[x]:id[y];//find smaller id that need to be updated for all bigger ones
		//int bsearch = (id[x]>id[y])? id[x]:id[y];//find bigger value need to be searched
		for(int i=0;i<id.length;i++)
		{
			//if(id[i]==bsearch) id[i]=key;
			if(id[i]==id[y])id[i]=id[x];
		}
	}
	
	public int root(int no)
	{
		while(id[no]!=no)no=id[no];
		return no;
	}
	
	public void tunion(int x, int y)
	{
		id[y]=root(x);
	}
	public boolean tfind(int x, int y)
	{
		if(root(x)==root(y))return true;
		return false;
	}

	public static void main(String []args)
	{
		int N = 10;
		Unionfind uf = new Unionfind(N);
		int input[][]= {{4,3},{3,8},{6,5},{9,4},{2,1},{8,9},{5,0},{7,2},{6,1},{1,0},{6,7}};
		for(int i=0;i<N;i++)
		{
			uf.union(input[i][0],input[i][1]);
		}
		
		if(uf.connected(9, 3))
			System.out.println("True");
		Unionfind tuf = new Unionfind(N);
		for(int i=0;i<N;i++)
		{
			tuf.union(input[i][0],input[i][1]);
		}
		
		if(tuf.connected(9, 0))
			System.out.println("True");
		
	}

}
