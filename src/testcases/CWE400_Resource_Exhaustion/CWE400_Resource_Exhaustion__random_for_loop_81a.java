/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__random_for_loop_81a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__random_for_loop_81a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        SecureRandom r = new SecureRandom();
        count = r.nextInt();

        CWE400_Resource_Exhaustion__random_for_loop_81_base o = new CWE400_Resource_Exhaustion__random_for_loop_81_bad();
        o.action(count );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        CWE400_Resource_Exhaustion__random_for_loop_81_base o = new CWE400_Resource_Exhaustion__random_for_loop_81_goodG2B();
        o.action(count );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        SecureRandom r = new SecureRandom();
        count = r.nextInt();

        CWE400_Resource_Exhaustion__random_for_loop_81_base o = new CWE400_Resource_Exhaustion__random_for_loop_81_goodB2G();
        o.action(count );
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
