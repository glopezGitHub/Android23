/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_random_multiply_73b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_random_multiply_73b
{

    public void bad_sink(LinkedList<Integer> data_linkedlist ) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        if(data > 0)   /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(LinkedList<Integer> data_linkedlist ) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        if(data > 0)   /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(LinkedList<Integer> data_linkedlist ) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        if(data > 0)   /* ensure we won't have an underflow */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < (Integer.MAX_VALUE/2))
            {
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform multiplication.");
            }
        }

    }
}
