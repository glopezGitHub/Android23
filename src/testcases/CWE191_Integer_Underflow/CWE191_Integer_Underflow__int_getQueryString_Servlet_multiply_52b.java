/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_52b.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_52b
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_52c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_52c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE191_Integer_Underflow__int_getQueryString_Servlet_multiply_52c()).goodB2G_sink(data , request, response);
    }
}
