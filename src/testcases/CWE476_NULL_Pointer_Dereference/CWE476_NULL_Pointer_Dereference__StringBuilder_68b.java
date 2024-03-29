/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_68b.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_68b
{

    public void bad_sink() throws Throwable
    {
        StringBuilder data = CWE476_NULL_Pointer_Dereference__StringBuilder_68a.data;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        StringBuilder data = CWE476_NULL_Pointer_Dereference__StringBuilder_68a.data;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        StringBuilder data = CWE476_NULL_Pointer_Dereference__StringBuilder_68a.data;

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
