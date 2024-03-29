/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_41.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_41 extends AbstractTestCase
{

    private void bad_sink(StringBuilder data ) throws Throwable
    {

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());

    }

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        bad_sink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2B_sink(StringBuilder data ) throws Throwable
    {

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;

        /* FIX: hardcode data to non-null */
        data = new StringBuilder();

        goodG2B_sink(data  );
    }

    private void goodB2G_sink(StringBuilder data ) throws Throwable
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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        goodB2G_sink(data  );
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
