/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_database_sub_54b.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_database_sub_54b
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_database_sub_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_database_sub_54c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_database_sub_54c()).goodB2G_sink(data );
    }
}
