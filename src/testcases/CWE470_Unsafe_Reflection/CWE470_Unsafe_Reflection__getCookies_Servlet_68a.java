/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getCookies_Servlet_68a.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: Set data to a hardcoded class name
 * BadSink:  Instantiate class named in data
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__getCookies_Servlet_68a extends AbstractTestCaseServlet
{

    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        data = ""; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                data = cookieSources[0].getValue();
            }
        }

        (new CWE470_Unsafe_Reflection__getCookies_Servlet_68b()).bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: Use a hardcoded class name */
        data = "Testing.test";

        (new CWE470_Unsafe_Reflection__getCookies_Servlet_68b()).goodG2B_sink(request, response);
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
