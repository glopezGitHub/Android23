/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE180_Validate_Before_Canonicalize__Servlet_16.java
Label Definition File: CWE180_Validate_Before_Canonicalize__Servlet.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 180 Validate Before Canonicalize
* Sinks:
*    GoodSink: canonicalize before validate
*    BadSink : validate before canonicalize
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE180_Validate_Before_Canonicalize;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE180_Validate_Before_Canonicalize__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
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
