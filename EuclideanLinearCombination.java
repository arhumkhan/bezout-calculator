import java.util.Scanner;

/**
* EuclideanLinearCombination takes two numbers as input,
* finds the GCD of those two numbers with the Euclidean Algorithm (saving each step), 
* and finally works backwards through the steps, combining each previous expression
* to arrive at the linear combination of the GCD from our two inputs.
* 
* @author  Arhum Khan
*/
public class EuclideanLinearCombination 
{
	public static void main(String[] args)
	{
		int[] aScalar = new int[]{1,1,1,1,1,1,1,1,1,1};
		int[] numA = new int[10];
		int[] bScalar = new int[]{1,0,0,0,0,0,0,0,0,0};
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
		
		//loop iterates past our gcd value twice
		diff = numA[steps - 2] % numB[steps - 2];
		steps = steps - 2;
		
		System.out.println("Working backwards from the end to the beginning:");
		//decrementing down from 'steps'
		while(steps > 0)
		{
			System.out.println("Iteration #" + steps + ": ");
			aScalar[steps] = aScalar[steps] + (bScalar[steps] * bScalar[steps - 1]);
			bScalar[steps] = (aScalar[steps - 1]) * bScalar[steps];
			numB[steps] = numA[steps - 1];
			System.out.print(diff + " = " 
					+ aScalar[steps] + "(" + numA[steps] + ")" + " - " 
					+ bScalar[steps] + "(" + numB[steps] + ")");
			
			//switching sides of our constant (scalar) and variable number
			int placeHolder = 0;
			placeHolder = aScalar[steps];
			aScalar[steps] = bScalar[steps];
			bScalar[steps] = placeHolder;
			placeHolder = numA[steps];
			numA[steps] = numB[steps];
			numB[steps] = placeHolder;
			
			//reassigning our new combined expression
			//to the previous 'step' expression used
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
