/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_check_min_67a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: large_fixed Set data to a value greater than the size of the array
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_min
 *    GoodSink: Read from array after verifying that data is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data is at least 0 (but not verifying that data less than array.length)
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_check_min_67a extends AbstractTestCase
{

    static class Container
    {
        public int a;
    }

    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        Container data_container = new Container();
        data_container.a = data;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_check_min_67b()).bad_sink(data_container  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        Container data_container = new Container();
        data_container.a = data;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_check_min_67b()).goodG2B_sink(data_container  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        Container data_container = new Container();
        data_container.a = data;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_read_check_min_67b()).goodB2G_sink(data_container  );
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
