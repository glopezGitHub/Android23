/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE180_Validate_Before_Canonicalize__Servlet_17.java
Label Definition File: CWE180_Validate_Before_Canonicalize__Servlet.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 180 Validate Before Canonicalize
* Sinks:
*    GoodSink: canonicalize before validate
*    BadSink : validate before canonicalize
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE180_Validate_Before_Canonicalize;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE180_Validate_Before_Canonicalize__Servlet_17 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
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

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
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
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
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
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
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
