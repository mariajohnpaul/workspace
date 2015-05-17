package helloworld;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String Str = "Hello world";
		String Str2="";
		String Str3="";
		
/*		for(int i=Str.length()-1;i!=-1;i--)
		{
	//		System.out.print(Str.charAt(i));
			Str2=Str2+Str.charAt(i);
		}
		String ar[] = Str2.split(" ");
		
		for(int i=ar.length-1;i>-1;i--)
		System.out.print(ar[i]+" ");*/
		
		byte jp=-128;
		for(int i=0;i<8;i++)
		{
			Str2+=((jp&(1<<(i)))>>i);			
		System.out.print((jp&(1<<(i)))>>i);
		}
		
		Str3 = new StringBuilder(Str2).reverse().toString();
		System.out.println("\n"+Str3);
/*		for(jp=0;jp<200;jp++)
			System.out.println(jp);
*/
	}
}
