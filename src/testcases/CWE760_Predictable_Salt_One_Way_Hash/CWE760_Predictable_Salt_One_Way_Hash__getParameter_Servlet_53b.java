/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_53b.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

public class CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_53b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_53c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE760_Predictable_Salt_One_Way_Hash__getParameter_Servlet_53c()).goodB2G_sink(data , request, response);
    }
}
