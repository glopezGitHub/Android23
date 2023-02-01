/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_07.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: MessageDigest_update
*    GoodSink: Include call to MessageDigest.update()
*    BadSink : Missing call to MessageDigest.update()
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE325_Missing_Required_Cryptographic_Step;

import testcasesupport.*;

import java.security.NoSuchAlgorithmException;

import java.security.MessageDigest;

public class CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        if (private_five==5)
        {
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */
            IO.writeLine(IO.toHex(sha.digest()));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            final String HASH_INPUT = "ABCDEFG123456";

            MessageDigest sha = MessageDigest.getInstance("SHA-1");

            /* FIX: Include call to MessageDigest.update() */
            sha.update(HASH_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(sha.digest()));

        }
    }

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1() throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */
            IO.writeLine(IO.toHex(sha.digest()));
        }
        else {

            final String HASH_INPUT = "ABCDEFG123456";

            MessageDigest sha = MessageDigest.getInstance("SHA-1");

            /* FIX: Include call to MessageDigest.update() */
            sha.update(HASH_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(sha.digest()));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_five==5)
        {
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FIX: Include call to MessageDigest.update() */
            sha.update(HASH_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(sha.digest()));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            final String HASH_INPUT = "ABCDEFG123456";

            MessageDigest sha = MessageDigest.getInstance("SHA-1");

            /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */

            IO.writeLine(IO.toHex(sha.digest()));

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