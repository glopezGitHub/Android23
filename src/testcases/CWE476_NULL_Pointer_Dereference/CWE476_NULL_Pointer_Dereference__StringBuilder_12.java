/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_12.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* BadSource:  Set data to null
* GoodSource: Set data to a non-null value
* Sinks:
*    GoodSink: add check to prevent possibility of null dereference
*    BadSink : possibility of null dereference
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: data is null */
            data = null;
        }
        else {

            /* FIX: hardcode data to non-null */
            data = new StringBuilder();

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
        }
        else {

            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length());
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: hardcode data to non-null */
            data = new StringBuilder();
        }
        else {

            /* FIX: hardcode data to non-null */
            data = new StringBuilder();

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
        }
        else {

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: data is null */
            data = null;
        }
        else {

            /* POTENTIAL FLAW: data is null */
            data = null;

        }
        if(IO.static_returns_t_or_f())
        {
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length());
            }
            else
            {
                IO.writeLine("data is null");
            }
        }
        else {

            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length());
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
