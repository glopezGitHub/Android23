/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_console_readLine_multiply_81_goodG2B.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
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

public class CWE191_Integer_Underflow__short_console_readLine_multiply_81_goodG2B extends CWE191_Integer_Underflow__short_console_readLine_multiply_81_base
{

    public void action(short data ) throws Throwable
    {

        if(data < 0)   /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Short.MIN_VALUE, this will underflow */
            short result = (short)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

}
