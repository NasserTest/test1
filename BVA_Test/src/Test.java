/* Test Driver for Triangle Class
 * (C) 2014 Stephen T. Frezza
 */

import Triangle.*; // finds class from .jar archive (library)
import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// From Test Suite Record:
		int a, b, c;
		String sExpectedResult;

		try {
			File fTestSuite = new File("TestSuite.csv");
			Scanner sSuiteScanner = new Scanner(fTestSuite);
			sSuiteScanner.useDelimiter(",|\n|\r");
			
			String sOutputFileName = fTestSuite.getName() + "_results";
			PrintWriter pwResults = new PrintWriter(sOutputFileName);
			
			while (sSuiteScanner.hasNext()) {
				int iTestId = sSuiteScanner.nextInt();
				a = sSuiteScanner.nextInt();
				b = sSuiteScanner.nextInt();
				c = sSuiteScanner.nextInt();
				sExpectedResult = sSuiteScanner.next();
				sSuiteScanner.nextLine();

				// run test
				boolean bPassed = false;
				Triangle t = new Triangle(a, b, c);
				String sActualResult = t.GetType();

				// record result
				bPassed = sActualResult.contains(sExpectedResult);
				System.out.println("The answer was " + bPassed + " for test " + iTestId );
				
				
				pwResults.println(iTestId + "," + a + ","  + b + "," + c + "," + sExpectedResult + "," + sActualResult + "," + bPassed );
				
			}
			pwResults.close();
			sSuiteScanner.close();
		} 
		catch (FileNotFoundException e) {
			System.out.print("Some file is screwed up " );

		}

	}

}