/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE615_Info_Exposure_by_Comment__Servlet_11.java
Label Definition File: CWE615_Info_Exposure_by_Comment__Servlet.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 615 Information Exposure by Comment
* Sinks:
*    GoodSink: no disclosure of username and password
*    BadSink : disclose username and password
* Flow Variant: 11 Control flow: if(IO.static_returns_t()) and if(IO.static_returns_f())
*
* */

package testcases.CWE615_Info_Exposure_by_Comment;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE615_Info_Exposure_by_Comment__Servlet_11 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_returns_t())
        {
            /* FLAW: sensitive information exposed in client-side code comments */
            response.getWriter().println("<!--DB username = joe, DB password = 123-->" +
            "<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: no info exposure in client-side code comments */
            response.getWriter().println("<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");

        }
    }

    /* good1() changes IO.static_returns_t() to IO.static_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: sensitive information exposed in client-side code comments */
            response.getWriter().println("<!--DB username = joe, DB password = 123-->" +
            "<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
        }
        else {

            /* FIX: no info exposure in client-side code comments */
            response.getWriter().println("<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_returns_t())
        {
            /* FIX: no info exposure in client-side code comments */
            response.getWriter().println("<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: sensitive information exposed in client-side code comments */
            response.getWriter().println("<!--DB username = joe, DB password = 123-->" +
            "<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
