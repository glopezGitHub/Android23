/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_15.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__equals_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int a = 1, b = 5;
            IO.writeLine(a);
            /* FIX: Assign b to a */
            a = b;
            IO.writeLine(a);
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        break;
        default:
        {
            int a = 1, b = 5;
            IO.writeLine(a);
            /* FIX: Assign b to a */
            a = b;
            IO.writeLine(a);
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            int a = 1, b = 5;
            IO.writeLine(a);
            /* FIX: Assign b to a */
            a = b;
            IO.writeLine(a);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        break;
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
