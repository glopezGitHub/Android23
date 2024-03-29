/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE784_Reliance_on_Cookies_in_a_Security_Decision__Servlet_08.java
Label Definition File: CWE784_Reliance_on_Cookies_in_a_Security_Decision__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 784 Cookies used to make a security decision; in this case a cookie is used to tell whether someone has administrator privileges
* Sinks: cookieInSecurityDecisionServlet
*    GoodSink: Uses isUserInRole() to authorize user
*    BadSink : Uses the cookie to authorize user
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE784_Reliance_on_Cookies_in_a_Security_Decision;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.Permissions;
import java.security.SecurityPermission;
import java.io.IOException;

public class CWE784_Reliance_on_Cookies_in_a_Security_Decision__Servlet_08 extends AbstractTestCaseServlet
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_returns_t())
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("role"))
                {
                    if (c.getValue().equals("admin"))
                    {
                        admin = true;
                    }
                }
            }
            if (admin)
            {
                /* FLAW: Privilege is granted based on a cookie value */
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            HttpSession session = request.getSession(true);

            boolean admin = false;
            /* FIX:  do not use cookies to determin group membership*/
            admin = request.isUserInRole("admin");

            if (admin)
            {
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            HttpSession session = request.getSession(true);
            boolean admin = false;
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("role"))
                {
                    if (c.getValue().equals("admin"))
                    {
                        admin = true;
                    }
                }
            }
            if (admin)
            {
                /* FLAW: Privilege is granted based on a cookie value */
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        else {

            HttpSession session = request.getSession(true);

            boolean admin = false;
            /* FIX:  do not use cookies to determin group membership*/
            admin = request.isUserInRole("admin");

            if (admin)
            {
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            /* FIX:  do not use cookies to determin group membership*/
            admin = request.isUserInRole("admin");
            if (admin)
            {
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            HttpSession session = request.getSession(true);

            boolean admin = false;
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("role"))
                {
                    if (c.getValue().equals("admin"))
                    {
                        admin = true;
                    }
                }
            }

            if (admin)
            {
                /* FLAW: Privilege is granted based on a cookie value */
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }

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
