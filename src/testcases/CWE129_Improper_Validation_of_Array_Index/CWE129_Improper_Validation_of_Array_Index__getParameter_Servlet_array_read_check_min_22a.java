/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_read_check_min_22a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-22a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_min
 *    GoodSink: Read from array after verifying that data is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data is at least 0 (but not verifying that data less than array.length)
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_read_check_min_22a extends AbstractTestCaseServlet
{

    /* The public static variable below is used to drive control flow in the sink function.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean bad_public_static = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", nfe);
            }
        }

        bad_public_static = true;
        (new CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_read_check_min_22b()).bad_sink(data , request, response);
    }

    /* The public static variables below are used to drive control flow in the sink functions.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodB2G1_public_static = false;
    public static boolean goodB2G2_public_static = false;
    public static boolean goodG2B_public_static = false;

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G1(request, response);
        goodB2G2(request, response);
        goodG2B(request, response);
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", nfe);
            }
        }

        goodB2G1_public_static = false;
        (new CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_read_check_min_22b()).goodB2G1_sink(data , request, response);
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", nfe);
            }
        }

        goodB2G2_public_static = true;
        (new CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_read_check_min_22b()).goodB2G2_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2B_public_static = true;
        (new CWE129_Improper_Validation_of_Array_Index__getParameter_Servlet_array_read_check_min_22b()).goodG2B_sink(data , request, response);
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