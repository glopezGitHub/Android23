/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_31.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

import java.net.PasswordAuthentication;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_31 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

            data_copy = data;
        }
        {
            String data = data_copy;

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication gsCreds = new PasswordAuthentication("user", "GP@ssw0rd".toCharArray());

            /* FIX: Set data to a hash of credentials */
            {
                String salt = "ThisIsMySalt";
                MessageDigest dig = MessageDigest.getInstance("SHA-512");
                dig.reset();
                String credsToHash = gsCreds.getUserName() + ":" + (new String(gsCreds.getPassword()));
                byte[] bHashedCreds = dig.digest((salt+credsToHash).getBytes("UTF-8"));
                data = IO.toHex(bHashedCreds);
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

            data_copy = data;
        }
        {
            String data = data_copy;

            /* FIX: Hash data before storing in cookie */
            {
                String salt = "ThisIsMySalt";
                MessageDigest dig = MessageDigest.getInstance("SHA-512");
                dig.reset();
                byte[] bHashedCreds = dig.digest((salt+data).getBytes("UTF-8"));
                data = IO.toHex(bHashedCreds);
            }
            response.addCookie(new Cookie("auth", data));

        }
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
