/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE383_Direct_Use_of_Threads__Servlet_01.java
Label Definition File: CWE383_Direct_Use_of_Threads__Servlet.label.xml
Template File: point-flaw-badonly-01.tmpl.java
*/
/*
* @description
* CWE: 383 J2EE Bad Practices Direct Use Of Threads
* Sinks:
*    BadSink : performs thread management
*	 BadOnly (No GoodSink)
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE383_Direct_Use_of_Threads;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE383_Direct_Use_of_Threads__Servlet_01 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: performing thread management in J2EE */
        Runnable r = new Runnable()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(10000); /* perform a long calculation */
                }
                catch (InterruptedException e)
                {
                    IO.writeLine("InterruptedException");
                }
            }
        };

        Thread t = new Thread(r);
        t.start();

        /* wait for the thread, check every second */
        while(true)
        {
            if (!t.isAlive())
            {
                break;
            }
            Thread.sleep(1000);
        }

        response.getWriter().write("thread is done!");

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* DO NOTHING - BadOnly test case */
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

