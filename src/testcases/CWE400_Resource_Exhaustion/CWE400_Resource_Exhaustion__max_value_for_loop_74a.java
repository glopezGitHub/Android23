/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__max_value_for_loop_74a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__max_value_for_loop_74a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        HashMap<Integer,Integer> count_hashmap = new HashMap<Integer,Integer>();
        count_hashmap.put(0, count);
        count_hashmap.put(1, count);
        count_hashmap.put(2, count);
        (new CWE400_Resource_Exhaustion__max_value_for_loop_74b()).bad_sink(count_hashmap  );
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

        HashMap<Integer,Integer> count_hashmap = new HashMap<Integer,Integer>();
        count_hashmap.put(0, count);
        count_hashmap.put(1, count);
        count_hashmap.put(2, count);
        (new CWE400_Resource_Exhaustion__max_value_for_loop_74b()).goodG2B_sink(count_hashmap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        HashMap<Integer,Integer> count_hashmap = new HashMap<Integer,Integer>();
        count_hashmap.put(0, count);
        count_hashmap.put(1, count);
        count_hashmap.put(2, count);
        (new CWE400_Resource_Exhaustion__max_value_for_loop_74b()).goodB2G_sink(count_hashmap  );
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
