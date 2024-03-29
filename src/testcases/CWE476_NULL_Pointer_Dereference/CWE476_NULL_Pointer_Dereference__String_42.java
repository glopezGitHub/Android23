/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__String_42.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__String_42 extends AbstractTestCase
{

    private String bad_source() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        return data;
    }

    public void bad() throws Throwable
    {
        String data = bad_source();

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());

    }

    /* goodG2B() - use goodsource and badsink */
    private String goodG2B_source() throws Throwable
    {
        String data;

        /* FIX: hardcode data to non-null */
        data = "This is not null";

        return data;
    }

    private void goodG2B() throws Throwable
    {
        String data = goodG2B_source();

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());

    }

    /* goodB2G() - use badsource and goodsink */
    private String goodB2G_source() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        return data;
    }

    private void goodB2G() throws Throwable
    {
        String data = goodB2G_source();

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
