/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE180_Validate_Before_Canonicalize__Servlet_15.java
Label Definition File: CWE180_Validate_Before_Canonicalize__Servlet.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 180 Validate Before Canonicalize
* Sinks:
*    GoodSink: canonicalize before validate
*    BadSink : validate before canonicalize
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE180_Validate_Before_Canonicalize;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE180_Validate_Before_Canonicalize__Servlet_15 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            if (request.getParameter("value") != null)
            {
                /* FLAW: Validation before canonicalization */
                if (request.getParameter("value").matches("(blah|blah2)"))
                {
                    response.getWriter().println("Invalid value for value");
                }
                else
                {
                    String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
                    response.getWriter().println("Value is: " + UTF8_value); /* INCIDENTAL: CWE80 Cross Site Scripting */
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (request.getParameter("value") != null)
            {
                /* FIX: canonicalization before validation */
                String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
                if (UTF8_value.matches("(blah|blah2)"))
                {
                    response.getWriter().println("Invalid value for value");
                }
                else
                {
                    response.getWriter().println("Value is: " + UTF8_value); /* INCIDENTAL: CWE80 Cross Site Scripting */
                }
            }
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (request.getParameter("value") != null)
            {
                /* FLAW: Validation before canonicalization */
                if (request.getParameter("value").matches("(blah|blah2)"))
                {
                    response.getWriter().println("Invalid value for value");
                }
                else
                {
                    String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
                    response.getWriter().println("Value is: " + UTF8_value); /* INCIDENTAL: CWE80 Cross Site Scripting */
                }
            }
        }
        break;
        default:
        {
            if (request.getParameter("value") != null)
            {
                /* FIX: canonicalization before validation */
                String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
                if (UTF8_value.matches("(blah|blah2)"))
                {
                    response.getWriter().println("Invalid value for value");
                }
                else
                {
                    response.getWriter().println("Value is: " + UTF8_value); /* INCIDENTAL: CWE80 Cross Site Scripting */
                }
            }
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            if (request.getParameter("value") != null)
            {
                /* FIX: canonicalization before validation */
                String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
                if (UTF8_value.matches("(blah|blah2)"))
                {
                    response.getWriter().println("Invalid value for value");
                }
                else
                {
                    response.getWriter().println("Value is: " + UTF8_value); /* INCIDENTAL: CWE80 Cross Site Scripting */
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (request.getParameter("value") != null)
            {
                /* FLAW: Validation before canonicalization */
                if (request.getParameter("value").matches("(blah|blah2)"))
                {
                    response.getWriter().println("Invalid value for value");
                }
                else
                {
                    String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
                    response.getWriter().println("Value is: " + UTF8_value); /* INCIDENTAL: CWE80 Cross Site Scripting */
                }
            }
        }
        break;
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
