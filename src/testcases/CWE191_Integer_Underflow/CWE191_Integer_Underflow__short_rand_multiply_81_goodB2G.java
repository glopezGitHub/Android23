/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_rand_multiply_81_goodB2G.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE191_Integer_Underflow__short_rand_multiply_81_goodB2G extends CWE191_Integer_Underflow__short_rand_multiply_81_base
{

    public void action(short data ) throws Throwable
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
