/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__getCookies_Servlet_52c.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

public class CWE760_Predictable_Salt_One_Way_Hash__getCookies_Servlet_52c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        SecureRandom r = new SecureRandom();

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
        byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));

        IO.writeLine(IO.toHex(hashv));

    }
}
