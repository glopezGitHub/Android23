/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__basic_02.java
Label Definition File: CWE328_Reversible_One_Way_Hash__basic.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 328 Bad case uses insecure cryptographic hashing algorithm (MD5). Good case uses secure cryptographic hashing algorithm (SHA-512).
* Sinks:
*    GoodSink: sha512
*    BadSink : md5
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__basic_02 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (true)
        {
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (MD5) */
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] hashv = hash.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashv));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String input = "Test Input";

            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            byte[] hashv = hash.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashv));

        }
    }

    /* good1() changes true to false */
    private void good1() throws Throwable
    {
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (MD5) */
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] hashv = hash.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashv));
        }
        else {

            String input = "Test Input";

            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            byte[] hashv = hash.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashv));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(true)
        {
            String input = "Test Input";
            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            byte[] hashv = hash.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashv));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String input = "Test Input";

            /* FLAW: Insecure cryptographic hashing algorithm (MD5) */
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] hashv = hash.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashv));

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
