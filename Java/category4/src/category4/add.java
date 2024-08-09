package category4;

public class add {
	public int fun(int a,int b)
	{
		int c=a+b;
		return c;
	}
	public static void main(String [] args) {
		int a=3,b=5;
		add o =new add();
		int k = o.fun(a, b);
	System.out.println(k);
	}

}
