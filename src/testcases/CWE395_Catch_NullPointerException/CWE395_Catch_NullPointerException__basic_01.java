/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE395_Catch_NullPointerException__basic_01.java
Label Definition File: CWE395_Catch_NullPointerException__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 395 Use of NullPointerException Catch to Detect NULL Pointer Dereference
* Sinks:
*    GoodSink: Check for null before taking action
*    BadSink : Catch NullPointerException to detect null
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE395_Catch_NullPointerException;

import testcasesupport.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE395_Catch_NullPointerException__basic_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        String data = System.getProperty("CWE395");

        try
        {
            /* INCIDENTAL: Possible Null Pointer Dereference (CWE476 / CWE690) */
            if(data.equals("CWE395"))
            {
                IO.writeLine("data is CWE395");
            }
        }
        catch (NullPointerException npe) /* FLAW: Use of catch block to detect null dereferences */
        {
            IO.writeLine("data is null");
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        String data;

        data = System.getProperty("CWE395");

        if(data != null) /* FIX: Check for null before calling equals() */
        {
            if(data.equals("CWE395"))
            {
                IO.writeLine("data is CWE395");
            }
        }
        else
        {
            IO.writeLine("data is null");
        }

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

