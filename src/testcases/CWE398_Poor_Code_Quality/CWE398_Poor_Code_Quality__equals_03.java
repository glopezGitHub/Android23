/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_03.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__equals_03 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (5==5)
        {
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int a = 1, b = 5;

            IO.writeLine(a);

            /* FIX: Assign b to a */
            a = b;

            IO.writeLine(a);

        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        else {

            int a = 1, b = 5;

            IO.writeLine(a);

            /* FIX: Assign b to a */
            a = b;

            IO.writeLine(a);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(5==5)
        {
            int a = 1, b = 5;
            IO.writeLine(a);
            /* FIX: Assign b to a */
            a = b;
            IO.writeLine(a);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */

            IO.writeLine(a);

            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;

            IO.writeLine(a);

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
