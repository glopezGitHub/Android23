/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__listen_tcp_74b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__listen_tcp_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

}
