/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE572_Call_to_Thread_run_Instead_of_start__basic_14.java
Label Definition File: CWE572_Call_to_Thread_run_Instead_of_start__basic.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 572 Call to Thread run instead of Thread start
* Sinks:
*    GoodSink: calls thread start
*    BadSink : calls thread run
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE572_Call_to_Thread_run_Instead_of_start;

import testcasesupport.*;

import java.io.*;

public class CWE572_Call_to_Thread_run_Instead_of_start__basic_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_five==5)
        {
            IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
                }
            };
            t.run(); /* FLAW: Called Thread.run() instead of Thread.start() */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("good() In thread: " + Thread.currentThread().getName());
                }
            };

            t.start(); /* FIX: Correctly called Thread.start() */

        }
    }

    /* good1() changes IO.static_five==5 to IO.static_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
                }
            };
            t.run(); /* FLAW: Called Thread.run() instead of Thread.start() */
        }
        else {

            IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("good() In thread: " + Thread.currentThread().getName());
                }
            };

            t.start(); /* FIX: Correctly called Thread.start() */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_five==5)
        {
            IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("good() In thread: " + Thread.currentThread().getName());
                }
            };
            t.start(); /* FIX: Correctly called Thread.start() */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
                }
            };

            t.run(); /* FLAW: Called Thread.run() instead of Thread.start() */

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