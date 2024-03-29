/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_13.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-13.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* BadSource:  Set data to null
* GoodSource: Set data to a non-null value
* Sinks:
*    GoodSink: add check to prevent possibility of null dereference
*    BadSink : possibility of null dereference
* Flow Variant: 13 Control flow: if(IO.static_final_five==5) and if(IO.static_final_five!=5)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_13 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;
        if(IO.static_final_five==5)
        {
            /* POTENTIAL FLAW: data is null */
            data = null;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: hardcode data to non-null */
            data = new StringBuilder();

        }
        if(IO.static_final_five==5)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_final_five==5 to IO.static_final_five!=5 */
    private void goodG2B1() throws Throwable
    {
        StringBuilder data;
        if(IO.static_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data is null */
            data = null;
        }
        else {

            /* FIX: hardcode data to non-null */
            data = new StringBuilder();

        }
        if(IO.static_final_five==5)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        StringBuilder data;
        if(IO.static_final_five==5)
        {
            /* FIX: hardcode data to non-null */
            data = new StringBuilder();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: data is null */
            data = null;

        }
        if(IO.static_final_five==5)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_final_five==5 to IO.static_final_five!=5 */
    private void goodB2G1() throws Throwable
    {
        StringBuilder data;
        if(IO.static_final_five==5)
        {
            /* POTENTIAL FLAW: data is null */
            data = null;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: hardcode data to non-null */
            data = new StringBuilder();

        }
        if(IO.static_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        StringBuilder data;
        if(IO.static_final_five==5)
        {
            /* POTENTIAL FLAW: data is null */
            data = null;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: hardcode data to non-null */
            data = new StringBuilder();

        }
        if(IO.static_final_five==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
