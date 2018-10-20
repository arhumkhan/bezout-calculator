
public class EuclideanLinearCombination 
{
	public static void main(String[] args)
	{
		int[] aScalar = new int[]{1,1,1,1,1,1,1,1,1,1};
		int[] numA = new int[10];
		int[] bScalar = new int[10];
		int[] numB = new int[10];
		
		aScalar[0] = 1;
		numA[0] = 97;
		bScalar[0] = 1;
		numB[0] = 57;
		
		int i = 1;
		int diff = numA[0] % numB[0];
		bScalar[0] = numA[0] / numB[0];
		
		
		System.out.println(diff + " = " 
				+ aScalar[0] + "(" + numA[0] + ")" + " - " 
				+ bScalar[0] + "(" + numB[0] + ")");
		
		while(diff > 0)
		{
			numA[i] = numB[i - 1];
			numB[i] = diff;
			diff = numA[i] % numB[i];
			bScalar[i] = numA[i] / numB[i];
			System.out.println(diff + " = " 
					+ aScalar[i] + "(" + numA[i] + ")" + " - " 
					+ bScalar[i] + "(" + numB[i] + ")");
			i++;
		}
		//this iterates past our gcd value twice so we gotta roll back our values... twice
		diff = numA[i-2] % numB[i-2];
		i = i - 2;
		
		
		System.out.println(" = = = = = =");
		
		//decrement down from i
		while(i > 0)
		{
			System.out.println("combining iteration: " + i);
			aScalar[i] = aScalar[i] + (bScalar[i] * bScalar[i - 1]);
			bScalar[i] = (aScalar[i - 1]) * bScalar[i];
			numB[i] = numA[i - 1];
			System.out.println(diff + " = " 
					+ aScalar[i] + "(" + numA[i] + ")" + " - " 
					+ bScalar[i] + "(" + numB[i] + ")");
			
			//switching places for consistency lol
			//bigger number to the left, num replaced to the right
			int placeHolder = 0;
			placeHolder = aScalar[i];
			aScalar[i] = bScalar[i];
			bScalar[i] = placeHolder;
			placeHolder = numA[i];
			numA[i] = numB[i];
			numB[i] = placeHolder;
			
			//annnnd the whole new equation into i - 1
			//probably a better way to do this
			aScalar[i-1] = aScalar[i];
			numA[i-1] = numA[i];
			bScalar[i-1] = bScalar[i];
			numB[i-1] = numB[i];
			
			i--;
		}
		
		System.out.println();
		System.out.println("The linear combination of " + numA[0] + " and " + numB[0] + " is:");
		System.out.println(diff + " = " 
				+ aScalar[0] + "(" + numA[0] + ") - " 
				+ bScalar[0] + "(" + numB[0] + ")");
		
	}
}
