/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__Environment_31.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE78_OS_Command_Injection__Environment_31 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data_copy;
        {
            String data;

            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            data = System.getenv("ADD");

            data_copy = data;
        }
        {
            String data = data_copy;

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

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data_copy;
        {
            String data;

            /* FIX: Use a hardcoded string */
            data = "foo";

            data_copy = data;
        }
        {
            String data = data_copy;

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
