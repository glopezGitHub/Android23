/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__database_54b.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-54b.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE78_OS_Command_Injection__database_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE78_OS_Command_Injection__database_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE78_OS_Command_Injection__database_54c()).goodG2B_sink(data );
    }

}
