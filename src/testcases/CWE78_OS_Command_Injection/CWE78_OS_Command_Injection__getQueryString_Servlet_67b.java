/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__getQueryString_Servlet_67b.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE78_OS_Command_Injection__getQueryString_Servlet_67b
{

    public void bad_sink(CWE78_OS_Command_Injection__getQueryString_Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE78_OS_Command_Injection__getQueryString_Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

}
