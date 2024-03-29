/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_connect_tcp_52b.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page without any encoding or validation
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_connect_tcp_52b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE80_XSS__Servlet_connect_tcp_52c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE80_XSS__Servlet_connect_tcp_52c()).goodG2B_sink(data , request, response);
    }

}
