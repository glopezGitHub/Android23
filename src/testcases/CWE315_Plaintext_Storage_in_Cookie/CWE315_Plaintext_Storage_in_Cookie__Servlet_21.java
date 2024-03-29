/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_21.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

import java.net.PasswordAuthentication;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_21 extends AbstractTestCaseServlet
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
        data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

        bad_private = true;
        bad_sink(data , request, response);
    }

    private void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(bad_private)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1_private = false;
    private boolean goodB2G2_private = false;
    private boolean goodG2B_private = false;

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G1(request, response);
        goodB2G2(request, response);
        goodG2B(request, response);
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
        data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

        goodB2G1_private = false;
        goodB2G1_sink(data , request, response);
    }

    private void goodB2G1_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        else {

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

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
        data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

        goodB2G2_private = true;
        goodB2G2_sink(data , request, response);
    }

    private void goodB2G2_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(goodB2G2_private)
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));

        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        goodG2B_private = true;
        goodG2B_sink(data , request, response);
    }

    private void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(goodG2B_private)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
