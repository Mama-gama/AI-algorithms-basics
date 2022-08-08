import java.util.*;
class dfs
{
	private final int V;
	private final LinkedList<Integer>[]adj;
	@SuppressWarnings("unchecked")
	dfs(int v)
	{
		V=v ; 
		adj=new LinkedList[v];
		for(int i=0 ; i<V ; ++i)
			adj[i]=new LinkedList();
	}
	public static void main(String args[])
	{
		dfs g=new dfs(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(3,3);
		System.out.println("Following is Depth first traversal");
		g.dfs();
	}
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	void dfsUtil(int v,boolean[] visited)
	{
		visited[v]=true;
		System.out.print(v+"");
		for(int n: adj[v])
		{
			if(!visited[n])
				dfsUtil(n,visited);
		}
	}
	void dfs()
	{
		boolean[]visited=new boolean[V];
		for(int i=0; i<V ; ++i)
		{
		if(!visited[i])
			dfsUtil(i,visited);
		}
	}
}