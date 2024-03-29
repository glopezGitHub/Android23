/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__time_17.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: time
*    GoodSink: after a certain date, print to the console
*    BadSink : after a certain date, launch an executable
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.io.*;

import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__time_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FLAW: date triggered backdoor */
            if (now.after(e))
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FIX: no backdoor exists */
            if (now.after(e))
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
            }
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FLAW: date triggered backdoor */
            if (now.after(e))
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FIX: no backdoor exists */
            if (now.after(e))
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
            }
        }
    }

    public void good() throws Throwable
    {
        good1();
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
