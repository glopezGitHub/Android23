/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__database_68b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: database Read data from a database
 * GoodSource: Set data to a hardcoded class name
 * BadSink:  Instantiate class named in data
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__database_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE470_Unsafe_Reflection__database_68a.data;

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE470_Unsafe_Reflection__database_68a.data;

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }
}
