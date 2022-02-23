
public class A4Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main(String[] args) {
		testStackOperations();
		testStackIsGeneric();
		testStackedCorrectly();
		testInsertPlate();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testStackOperations() {
		System.out.println("Stack Operations Tests:");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		Integer result = 0;
		Integer result1 = 0;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
		displayResults(testStack.pop()==null, "test pop() on empty stack");
		displayResults(testStack.top()==null, "test top() on empty stack");

		result = testStack.top(); // testing when the stack is empty
				
		testStack.push(2);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==2, "top works after initial push");
		
		//TODO: add more tests here

		testStack.push(3);
		testStack.push(4);
		result = testStack.top();
		displayResults(result==4, "top works after pushing two times");

		result1 = testStack.pop();
		//System.out.println(result1);
		displayResults(result1==4, "pop works after popping once");

		result1 = testStack.pop();
		//System.out.println(result1);
		displayResults(result1==3, "pop works after popping twice");

		result1 = testStack.pop();
		displayResults(result1==2, "pop works after popping three times");

		result1 = testStack.pop();
		//System.out.println(result1);
		displayResults(result1 == null, "pop works after popping until null");

		testStack.pop();
		testStack.pop();
		testStack.pop();

		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		result = testStack.top();
		displayResults(result==5, "top works after popping many times and pushing");
		
		result1 = testStack.pop();
		//System.out.println(result1);
		displayResults(result1==5, "pop works after popping once");

		testStack.popAll(); // making the stack empty
		displayResults(testStack.isEmpty(), "popAll works");

		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		result = testStack.top();
		displayResults(result==5, "top works after calling popAll");

		result1 = testStack.pop();
		displayResults(result1 == 5, "pop works after pushing");

		testStack.popAll(); // making the stack empty
		displayResults(testStack.isEmpty(), "popAll works after popping");
				
		System.out.println();
	}
	
	public static void testStackIsGeneric() {
		System.out.println("Stack Generics Tests:");
		A4Stack<Integer> s1 = new A4Stack<Integer>();
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		
		Integer result1;
		String result2;
		Double result3;
		
		s1.push(3);
		s1.push(8);
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.8);
		s3.push(9.1);
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1==8, "Integer Stack");
		displayResults(result2.equals("ENGR"), "String Stack");
		displayResults(result3==9.1, "Double Stack");		
		
		result1 = s1.top();
		result2 = s2.top();
		result3 = s3.top();
		
		displayResults(result1==3, "Integer Stack");
		displayResults(result2.equals("CSC"), "String Stack");
		displayResults(result3==9.8, "Double Stack");
		
		//TODO: add more tests here

		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();

		result1 = s1.pop(); // checking pop when it is empty
		result2 = s2.pop(); // *
		result3 = s3.pop(); // *
		
		System.out.println();
	}

	public static void testStackedCorrectly() {
		System.out.println("Testing stackedCorrectly");
		Plate p3 = new Plate(5);
		Plate p5 = new Plate(12);
		Plate p1 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p2 = new Plate(3);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		
		s1.push(p5);
		s1.push(p4);
		s1.push(p3);
		s1.push(p2);
		s1.push(p1);

		boolean result = false;
		String origin = "";
		
		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for five correct, with result");
		//displayResults(s1.size()==5, "test stackedCorrectly() for five correct, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for five correct, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for five correct, with top().getDiameter()");

		s1.popAll();
		s1.push(p5);
		s1.push(p3);
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		
		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(!result, "test stackedCorrectly() for five incorrect, with result");
		//displayResults(s1.size()==5, "test stackedCorrectly() for five incorrect, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for five incorrect, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for five incorrect, with top().getDiameter()");

		s1.popAll();
		s1.push(p1);
		s1.push(p4);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(!result, "test stackedCorrectly() for two incorrect, with result");
		//displayResults(s1.size()==2, "test stackedCorrectly() for two incorrect, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for two incorrect, with toString()");
		displayResults(s1.top().getDiameter()==8, "test stackedCorrectly() for two incorrect, with top().getDiameter()");
		
		s1.popAll();
		s1.push(p4);
		s1.push(p1);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for two correct, with result");
		//displayResults(s1.size()==2, "test stackedCorrectly() for two correct, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for two correct, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for two correct, with top().getDiameter()");

		s1.popAll();
		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for empty, with result");
		//displayResults(s1.size()==0, "test stackedCorrectly() for empty, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for empty, with toString()");
		displayResults(s1.top()==null, "test stackedCorrectly() for empty, with top()");

		s1.push(p5);
		s1.push(p4);
		s1.push(p3);
		s1.push(p1);
		s1.push(p2);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(!result, "test stackedCorrectly() for incorrect top, with result");
		//displayResults(s1.size()==5, "test stackedCorrectly() for incorrect top, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for incorrect top, with toString()");
		displayResults(s1.top().getDiameter()==3, "test stackedCorrectly() for incorrect top, with top().getDiameter()");

		s1.popAll();
		s1.push(p4);
		s1.push(p5);
		s1.push(p3);
		s1.push(p2);
		s1.push(p1);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(!result, "test stackedCorrectly() for incorrect bottom, with result");
		//displayResults(s1.size()==5, "test stackedCorrectly() for incorrect bottom, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for incorrect bottom, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for incorrect bottom, with top().getDiameter()");

		s1.popAll();
		s1.push(p1);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for size 1, with result");
		//displayResults(s1.size()==1, "test stackedCorrectly() for size 1, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for size 1, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for size 1, with top().getDiameter()");

		s1.popAll();
		s1.push(p5);
		s1.push(p5);
		s1.push(p4);
		s1.push(p3);
		s1.push(p2);
		s1.push(p1);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for repeat on bottom, with result");
		//displayResults(s1.size()==6, "test stackedCorrectly() for repeat on bottom, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for repeat on bottom, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for repeat on bottom, with top().getDiameter()");

		s1.popAll();
		s1.push(p5);
		s1.push(p4);
		s1.push(p3);
		s1.push(p2);
		s1.push(p1);
		s1.push(p1);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for repeat on top, with result");
		//displayResults(s1.size()==6, "test stackedCorrectly() for repeat on top, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for repeat on top, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for repeat on top, with top().getDiameter()");

		s1.popAll();
		s1.push(p5);
		s1.push(p4);
		s1.push(p3);
		s1.push(p3);
		s1.push(p2);
		s1.push(p1);

		origin = s1.toString();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "test stackedCorrectly() for repeat in middle, with result");
		//displayResults(s1.size()==6, "test stackedCorrectly() for repeat in middle, with size()");
		displayResults(s1.toString().equals(origin), "test stackedCorrectly() for repeat in middle, with toString()");
		displayResults(s1.top().getDiameter()==1, "test stackedCorrectly() for repeat in middle, with top().getDiameter()");

		System.out.println();
	}

	public static void testInsertPlate() {
		System.out.println("Testing insertPlate");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		
		Plate insert = new Plate(6);
		Plate insert2 = new Plate(13);
		Plate insert3 = new Plate(1);
		Plate insert4 = new Plate(2);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into 5 elements");
		
		//TODO: add more tests here

		A4Exercises.insertPlate(s2, insert);
		//System.out.println(s2);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into empty stack");

		A4Exercises.insertPlate(s1, insert2);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into and inserted stack");

		A4Exercises.insertPlate(s1, insert3);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert a plate with the same plate inside the stack");

		A4Exercises.insertPlate(s1, insert);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert a plate with the same plate inside the stack");

		A4Exercises.insertPlate(s1, insert2);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "test insert back repeat num, with stackedCorrectly()");

		s1.pop();
		s1.pop();
		A4Exercises.insertPlate(s1, insert4);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "test insert in front, with stackedCorrectly()");
		
		s1.popAll();
		A4Exercises.insertPlate(s1, insert);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "test insert in empty, with stackedCorrectly()");

		A4Exercises.insertPlate(s1, p3);
		//System.out.println(s1);
		displayResults(A4Exercises.stackedCorrectly(s1), "test insert in one, with stackedCorrectly()");

	}

	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}