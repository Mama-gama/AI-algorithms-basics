class cfg
{
	static int max=1000;
	static int min=-1000;
	static int minmax(int depth, int nodeindex, boolean maximizingPlayer, int[]values, int alpha, int beta)
	{
	if(depth==3) 
		return values[nodeindex];
	if(maximizingPlayer)
	{
		int best=min;
		for(int i=0; i<2; i++)
		{
			int val=minmax(depth+1, nodeindex*2+i, false, values, alpha, beta);
			best= Math.max(best, val);
			alpha= Math.max(alpha, best);
			if(beta<=alpha)
				break;
		}
		return best;
	}
	else
	{
		int best = max;
		for(int i=0; i<2; i++)
		{
			int val=minmax(depth+1, nodeindex*2+i, true, values, alpha, beta);
			best=Math.min(best,val);
			beta=Math.min(beta, best);
			if(beta<=alpha)
				break;
		}
		return best;
	}
	}
	public static void main( String [] args)
	{
		int[]values={3,5,6,9,1,0,-1};
		System.out.println("the optimal value is : "+ minmax (0,0,true,values,min,max));
	}
}