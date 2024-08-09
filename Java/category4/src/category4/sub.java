package category4;

public class sub {
	public int fun(int a,int b)
	{
		int c=a-b;
		return c;
	}
	public static void main(String [] args) {
		int a=30,b=5;
		sub o =new sub();
		int k = o.fun(a, b);
	System.out.println(k);
	}

}
