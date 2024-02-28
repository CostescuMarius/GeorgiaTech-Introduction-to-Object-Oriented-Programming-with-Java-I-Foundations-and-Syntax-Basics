public class PrimitiveOperations {
    
	//TODO: Start your code after this line
	public static void main(String[] args) {
        	int integerVar = 5;
		double floatingPointVar = 3.5;

		double multiplyResult = integerVar * floatingPointVar;
		System.out.println(multiplyResult);

		double integerToFloatingPoint = (double) integerVar;
		System.out.println(integerToFloatingPoint);

		int floatingPointToInteger = (int) floatingPointVar;
		System.out.println(floatingPointToInteger);

		char uppercaseLetter = 'A';
		System.out.println(uppercaseLetter);

		char sameLetterLowercase = (char) ((int)'A' + 32);
		System.out.print(sameLetterLowercase);
	}
}