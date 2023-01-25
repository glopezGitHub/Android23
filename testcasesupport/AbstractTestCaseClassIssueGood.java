/*
@description This abstract class is meant to be used by testcases that have a flaw
outside of good or bad function.  These flaws are part of the class.  For an 
example, see CWE 580.

*/

package testcasesupport;

public abstract class AbstractTestCaseClassIssueGood extends AbstractTestCaseBase implements Cloneable {

	public abstract void good() throws Throwable;
	
	public void runTest(String classname) {

		IO.writeLine("Starting tests for Class " + classname);

		try {
			good();
	
			IO.writeLine("Completed good() for Class " + classname);
			
		} catch (Throwable t) {

			IO.writeLine("Caught a throwable from good() for Class "
					+ classname);

			IO.writeLine("Throwable's message = " + t.getMessage());
			
			StackTraceElement stes[] = t.getStackTrace();

			IO.writeLine("Stack trace below");

			for (StackTraceElement ste : stes) {

				IO.writeLine(ste.toString());

			} 

		}

	} // runTest
	
} // class
