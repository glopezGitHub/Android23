/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_listen_tcp_74b.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page without any encoding or validation
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_listen_tcp_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page without any encoding or validation */
            response.getWriter().println("<br>bad(): data = " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page without any encoding or validation */
            response.getWriter().println("<br>bad(): data = " + data);
        }

    }

}
