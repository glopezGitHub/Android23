/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_multiply_17.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: min Set data to the max value for short
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an underflow before multiplying data by 2
*    BadSink : If data is negative, multiply by 2, which can cause an underflow
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

public class CWE191_Integer_Underflow__short_min_multiply_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        short data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Short.MIN_VALUE;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Short.MIN_VALUE, this will underflow */
                short result = (short)(data * 2);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Short.MIN_VALUE/2))
                {
                    short result = (short)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Short.MIN_VALUE;
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Short.MIN_VALUE, this will underflow */
                short result = (short)(data * 2);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Short.MIN_VALUE/2))
                {
                    short result = (short)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G() throws Throwable
    {
        short data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Short.MIN_VALUE;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Short.MIN_VALUE, this will underflow */
                short result = (short)(data * 2);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Short.MIN_VALUE/2))
                {
                    short result = (short)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
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
