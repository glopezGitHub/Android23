/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_console_readLine_square_81_goodG2B.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

import java.lang.Math;

public class CWE190_Integer_Overflow__long_console_readLine_square_81_goodG2B extends CWE190_Integer_Overflow__long_console_readLine_square_81_base
{

    public void action(long data ) throws Throwable
    {

        /* POTENTIAL FLAW: if (data*data) > Long.MAX_VALUE, this will overflow */
        long result = (long)(data * data);

        IO.writeLine("result: " + result);

    }

}
