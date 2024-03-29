/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_71a.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-71a.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

public class CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_71a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        (new CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_71b()).bad_sink((Object)data , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_71b()).goodG2B_sink((Object)data , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        (new CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_71b()).goodB2G_sink((Object)data , request, response );
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
