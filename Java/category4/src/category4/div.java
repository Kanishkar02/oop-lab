package category4;

public class div {
	public int fun(int a,int b)
	{
		int c=a/b;
		return c;
	}
	public static void main(String [] args) {
		int a=30,b=5;
		div o =new div();
		int k = o.fun(a, b);
	System.out.println(k);
	}

}
