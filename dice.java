package dice1;

import java.util.Random;
import java.util.Scanner;
class dice
{
	int n;
public dice(int n)
{
	this.n=n;
}
int rolling()
{
	Random rand = new Random();

int  rn = rand.nextInt(n) + 1;
return rn;
}
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int choice;
	do
	{
		
	
		System.out.println("enter number of sides");
		
		int n=sc.nextInt();
		dice d= new dice(n);
		if(n==1)
		{
			System.out.println("dice can't be of one side only");
		}
		else
		{
		int k=d.rolling();
		System.out.println("number generated on dice is "+k);
		
		}
		System.out.println("enter 1 if u want to give input otherwise enter 0");
		 choice=sc.nextInt();

	}while(choice==1);
	
}
}