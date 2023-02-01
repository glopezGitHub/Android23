/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_03.java
Label Definition File: CWE563_Unused_Variable__unused_uninit_variable.label.xml
Template File: source-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  don't initialize data
* Sinks:
*    GoodSink: init and use data
*    BadSink : do nothing
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_03 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if (5==5)
        {
            /* FLAW: Don't initialize or use data */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Initialize then use data */
            data = new StringBuilder("Good");
            IO.writeLine(data.toString());

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing 5==5 to 5!=5 */
    private void goodB2G1() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Don't initialize or use data */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }
        else {

            /* FIX: Initialize then use data */
            data = new StringBuilder("Good");
            IO.writeLine(data.toString());

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in if  */
    private void goodB2G2() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Don't initialize or use data */
        ; /* empty statement needed for some flow variants */

        if(5==5)
        {
            /* FIX: Initialize then use data */
            data = new StringBuilder("Good");
            IO.writeLine(data.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Don't initialize or use data */
            /* do nothing */
            ; /* empty statement needed for some flow variants */

        }
    }

    public void good() throws Throwable
    {
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