/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__basic_12.java
Label Definition File: CWE328_Reversible_One_Way_Hash__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 328 Bad case uses insecure cryptographic hashing algorithm (MD5). Good case uses secure cryptographic hashing algorithm (SHA-512).
* Sinks:
*    GoodSink: sha512
*    BadSink : md5
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            String input = "Test Input";
            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
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

    public void good() throws Throwable
    {
        good1();
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
