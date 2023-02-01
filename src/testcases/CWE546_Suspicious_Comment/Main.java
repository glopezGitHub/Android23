package testcasesupport;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 0) {
		
			if(args[0].equals("-h") || args[0].equals("--help")) {
		
				System.err.println("To use this main, you can either run the program with no " +
				"command line arguments to run all test cases or you can specify one or more classes to test");
				System.err.println("For example:");
				System.err.println("java testcasesupport.Main testcases.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference.custom_function.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference__custom_function_01 testcases.CWE481_Assigning_instead_of_Comparing.bool.CWE481_Assigning_instead_of_Comparing__bool_01");
				System.exit(1);
			}
			
			/* User supplied some class names on the command line, just use those with introspection
			 *
			 * String classNames[] = { "CWE481_Assigning_instead_of_Comparing__boolean_01",
			 *		"CWE476_Null_Pointer_Dereference__getProperty_01" };
 			 * could read class names from command line or use
			 * http://sadun-util.sourceforge.net/api/org/sadun/util/
			 * ClassPackageExplorer.html
			 */

			for (String className : args) {

				try {
					
					/* String classNameWithPackage = "testcases." + className; */
					
					/* IO.writeLine("classNameWithPackage = " + classNameWithPackage); */

					Class<?> myClass = Class.forName(className);

					AbstractTestCase myObject = (AbstractTestCase) myClass
							.newInstance();

					myObject.runTest(className);

				} catch (Exception ex) {

					IO.writeLine("Could not run test for class " + className);
					ex.printStackTrace();

				}
				
				IO.writeLine(""); /* leave a blank line between classes */

			}

		} else {
		
			/* No command line args were used, we want to run every testcase */
			
			/* needed to separate these calls into other methods because
			   we were running into the size limit Java has for a single method */
			runTestCWE1();
			runTestCWE2();
			runTestCWE3();
			runTestCWE4();
			runTestCWE5();
			runTestCWE6();
			runTestCWE7();
			runTestCWE8();
			runTestCWE9();
		}			
	}

private static void runTestCWE1() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-1 */

			/* END-AUTOGENERATED-JAVA-TESTS-1 */
}

private static void runTestCWE2() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-2 */

			/* END-AUTOGENERATED-JAVA-TESTS-2 */
}

private static void runTestCWE3() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-3 */

			/* END-AUTOGENERATED-JAVA-TESTS-3 */
}

private static void runTestCWE4() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-4 */

			/* END-AUTOGENERATED-JAVA-TESTS-4 */
}

private static void runTestCWE5() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-5 */
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_01()).runTest("CWE546_Suspicious_Comment__BUG_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_02()).runTest("CWE546_Suspicious_Comment__BUG_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_03()).runTest("CWE546_Suspicious_Comment__BUG_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_04()).runTest("CWE546_Suspicious_Comment__BUG_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_05()).runTest("CWE546_Suspicious_Comment__BUG_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_06()).runTest("CWE546_Suspicious_Comment__BUG_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_07()).runTest("CWE546_Suspicious_Comment__BUG_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_08()).runTest("CWE546_Suspicious_Comment__BUG_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_09()).runTest("CWE546_Suspicious_Comment__BUG_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_10()).runTest("CWE546_Suspicious_Comment__BUG_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_11()).runTest("CWE546_Suspicious_Comment__BUG_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_12()).runTest("CWE546_Suspicious_Comment__BUG_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_13()).runTest("CWE546_Suspicious_Comment__BUG_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_14()).runTest("CWE546_Suspicious_Comment__BUG_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_15()).runTest("CWE546_Suspicious_Comment__BUG_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_16()).runTest("CWE546_Suspicious_Comment__BUG_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_17()).runTest("CWE546_Suspicious_Comment__BUG_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__BUG_19()).runTest("CWE546_Suspicious_Comment__BUG_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_01()).runTest("CWE546_Suspicious_Comment__FIXME_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_02()).runTest("CWE546_Suspicious_Comment__FIXME_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_03()).runTest("CWE546_Suspicious_Comment__FIXME_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_04()).runTest("CWE546_Suspicious_Comment__FIXME_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_05()).runTest("CWE546_Suspicious_Comment__FIXME_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_06()).runTest("CWE546_Suspicious_Comment__FIXME_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_07()).runTest("CWE546_Suspicious_Comment__FIXME_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_08()).runTest("CWE546_Suspicious_Comment__FIXME_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_09()).runTest("CWE546_Suspicious_Comment__FIXME_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_10()).runTest("CWE546_Suspicious_Comment__FIXME_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_11()).runTest("CWE546_Suspicious_Comment__FIXME_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_12()).runTest("CWE546_Suspicious_Comment__FIXME_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_13()).runTest("CWE546_Suspicious_Comment__FIXME_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_14()).runTest("CWE546_Suspicious_Comment__FIXME_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_15()).runTest("CWE546_Suspicious_Comment__FIXME_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_16()).runTest("CWE546_Suspicious_Comment__FIXME_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_17()).runTest("CWE546_Suspicious_Comment__FIXME_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__FIXME_19()).runTest("CWE546_Suspicious_Comment__FIXME_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_01()).runTest("CWE546_Suspicious_Comment__HACK_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_02()).runTest("CWE546_Suspicious_Comment__HACK_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_03()).runTest("CWE546_Suspicious_Comment__HACK_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_04()).runTest("CWE546_Suspicious_Comment__HACK_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_05()).runTest("CWE546_Suspicious_Comment__HACK_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_06()).runTest("CWE546_Suspicious_Comment__HACK_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_07()).runTest("CWE546_Suspicious_Comment__HACK_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_08()).runTest("CWE546_Suspicious_Comment__HACK_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_09()).runTest("CWE546_Suspicious_Comment__HACK_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_10()).runTest("CWE546_Suspicious_Comment__HACK_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_11()).runTest("CWE546_Suspicious_Comment__HACK_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_12()).runTest("CWE546_Suspicious_Comment__HACK_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_13()).runTest("CWE546_Suspicious_Comment__HACK_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_14()).runTest("CWE546_Suspicious_Comment__HACK_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_15()).runTest("CWE546_Suspicious_Comment__HACK_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_16()).runTest("CWE546_Suspicious_Comment__HACK_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_17()).runTest("CWE546_Suspicious_Comment__HACK_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__HACK_19()).runTest("CWE546_Suspicious_Comment__HACK_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_01()).runTest("CWE546_Suspicious_Comment__LATER_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_02()).runTest("CWE546_Suspicious_Comment__LATER_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_03()).runTest("CWE546_Suspicious_Comment__LATER_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_04()).runTest("CWE546_Suspicious_Comment__LATER_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_05()).runTest("CWE546_Suspicious_Comment__LATER_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_06()).runTest("CWE546_Suspicious_Comment__LATER_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_07()).runTest("CWE546_Suspicious_Comment__LATER_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_08()).runTest("CWE546_Suspicious_Comment__LATER_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_09()).runTest("CWE546_Suspicious_Comment__LATER_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_10()).runTest("CWE546_Suspicious_Comment__LATER_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_11()).runTest("CWE546_Suspicious_Comment__LATER_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_12()).runTest("CWE546_Suspicious_Comment__LATER_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_13()).runTest("CWE546_Suspicious_Comment__LATER_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_14()).runTest("CWE546_Suspicious_Comment__LATER_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_15()).runTest("CWE546_Suspicious_Comment__LATER_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_16()).runTest("CWE546_Suspicious_Comment__LATER_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_17()).runTest("CWE546_Suspicious_Comment__LATER_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__LATER_19()).runTest("CWE546_Suspicious_Comment__LATER_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_01()).runTest("CWE546_Suspicious_Comment__TODO_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_02()).runTest("CWE546_Suspicious_Comment__TODO_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_03()).runTest("CWE546_Suspicious_Comment__TODO_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_04()).runTest("CWE546_Suspicious_Comment__TODO_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_05()).runTest("CWE546_Suspicious_Comment__TODO_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_06()).runTest("CWE546_Suspicious_Comment__TODO_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_07()).runTest("CWE546_Suspicious_Comment__TODO_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_08()).runTest("CWE546_Suspicious_Comment__TODO_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_09()).runTest("CWE546_Suspicious_Comment__TODO_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_10()).runTest("CWE546_Suspicious_Comment__TODO_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_11()).runTest("CWE546_Suspicious_Comment__TODO_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_12()).runTest("CWE546_Suspicious_Comment__TODO_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_13()).runTest("CWE546_Suspicious_Comment__TODO_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_14()).runTest("CWE546_Suspicious_Comment__TODO_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_15()).runTest("CWE546_Suspicious_Comment__TODO_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_16()).runTest("CWE546_Suspicious_Comment__TODO_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_17()).runTest("CWE546_Suspicious_Comment__TODO_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__TODO_19()).runTest("CWE546_Suspicious_Comment__TODO_19");
			/* END-AUTOGENERATED-JAVA-TESTS-5 */
}

private static void runTestCWE6() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-6 */

			/* END-AUTOGENERATED-JAVA-TESTS-6 */
}

private static void runTestCWE7() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-7 */

			/* END-AUTOGENERATED-JAVA-TESTS-7 */
}

private static void runTestCWE8() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-8 */

			/* END-AUTOGENERATED-JAVA-TESTS-8 */
}

private static void runTestCWE9() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-9 */

			/* END-AUTOGENERATED-JAVA-TESTS-9 */
}
}