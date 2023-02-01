/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_console_readLine_sub_54e.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-54e.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

public class CWE191_Integer_Underflow__short_console_readLine_sub_54e
{

    public void bad_sink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(short data ) throws Throwable
    {

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Short.MIN_VALUE)
        {
            short result = (short)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}