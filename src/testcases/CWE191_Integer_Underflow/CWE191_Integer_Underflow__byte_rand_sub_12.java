/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_rand_sub_12.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: rand Set data to result of rand()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_rand_sub_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        byte data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE)+Byte.MIN_VALUE);
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
            byte result = (byte)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Byte.MIN_VALUE)
            {
                byte result = (byte)(data - 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too small to perform subtraction.");
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        byte data;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
            byte result = (byte)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {

            /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
            byte result = (byte)(data - 1);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        byte data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE)+Byte.MIN_VALUE);
        }
        else {

            /* POTENTIAL FLAW: Use a random value */
            data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE)+Byte.MIN_VALUE);

        }
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Byte.MIN_VALUE)
            {
                byte result = (byte)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
        }
        else {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Byte.MIN_VALUE)
            {
                byte result = (byte)(data - 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too small to perform subtraction.");
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