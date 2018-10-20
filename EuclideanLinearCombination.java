import java.util.Scanner;

public class EuclideanLinearCombination 
{
	public static void main(String[] args)
	{
		int[] aScalar = new int[]{1,1,1,1,1,1,1,1,1,1};
		int[] numA = new int[10];
		int[] bScalar = new int[10];
		int[] numB = new int[10];
		//can only do ten steps
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter first number:");
		numA[0] = kb.nextInt();
		System.out.println("Enter second number:");
		numB[0] = kb.nextInt();
		if(numB[0] > numA[0])
		{
			int x = numB[0];
			numB[0] = numA[0];
			numA[0] = x;
		}
		bScalar[0] = 1;
		
		System.out.println("Obtaining the GCD with Euclidean Algorithm:");
		int steps = 1;
		int diff = numA[0] % numB[0];
		bScalar[0] = numA[0] / numB[0];
		
		System.out.println(diff + " = " 
				+ aScalar[0] + "(" + numA[0] + ")" + " - " 
				+ bScalar[0] + "(" + numB[0] + ")");
		
		while(diff > 0)
		{
			numA[steps] = numB[steps - 1];
			numB[steps] = diff;
			diff = numA[steps] % numB[steps];
			bScalar[steps] = numA[steps] / numB[steps];
			System.out.println(diff + " = " 
					+ aScalar[steps] + "(" + numA[steps] + ")" + " - " 
					+ bScalar[steps] + "(" + numB[steps] + ")");
			steps++;
		}
		//this iterates past our gcd value twice so we gotta roll back our values... twice
		diff = numA[steps - 2] % numB[steps - 2];
		steps = steps - 2;
		
		
		System.out.println("Working backwards from the end to the beginning:");
		//decrement down from i
		while(steps > 0)
		{
			System.out.println("Iteration #" + steps);
			aScalar[steps] = aScalar[steps] + (bScalar[steps] * bScalar[steps - 1]);
			bScalar[steps] = (aScalar[steps - 1]) * bScalar[steps];
			numB[steps] = numA[steps - 1];
			System.out.println(diff + " = " 
					+ aScalar[steps] + "(" + numA[steps] + ")" + " - " 
					+ bScalar[steps] + "(" + numB[steps] + ")");
			
			//switching places for consistency lol
			//bigger number to the left, num replaced to the right
			int placeHolder = 0;
			placeHolder = aScalar[steps];
			aScalar[steps] = bScalar[steps];
			bScalar[steps] = placeHolder;
			placeHolder = numA[steps];
			numA[steps] = numB[steps];
			numB[steps] = placeHolder;
			
			//annnnd the whole new equation into steps - 1
			//probably a better way to do this
			aScalar[steps-1] = aScalar[steps];
			numA[steps-1] = numA[steps];
			bScalar[steps-1] = bScalar[steps];
			numB[steps-1] = numB[steps];
			
			steps--;
		}
		
		System.out.println();
		System.out.println("The linear combination of " + numA[0] + " and " + numB[0] + " is:");
		System.out.println(diff + " = " 
				+ aScalar[0] + "(" + numA[0] + ") - " 
				+ bScalar[0] + "(" + numB[0] + ")");
	}
}
