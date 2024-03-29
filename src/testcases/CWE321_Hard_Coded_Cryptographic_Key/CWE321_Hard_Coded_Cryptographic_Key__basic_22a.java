/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_22a.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-22a.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  Set data to a hardcoded value
 * GoodSource: Read data from the console using readLine()
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : Use data as a cryptographic key
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_22a extends AbstractTestCase
{

    /* The public static variable below is used to drive control flow in the source function.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean bad_public_static = false;

    public void bad() throws Throwable
    {
        String data;

        bad_public_static = true;
        data = (new CWE321_Hard_Coded_Cryptographic_Key__basic_22b()).bad_source();

        if (data != null)
        {
            String sToEncrypt = "Super secret Squirrel";
            byte[] bToEncrypt = sToEncrypt.getBytes("UTF-8");
            /* POTENTIAL FLAW: Use data as a cryptographic key */
            SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes("UTF-8"), "AES");
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
            byte[] bCipherText = aesCipher.doFinal(bToEncrypt);
            IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */
        }

    }

    /* The public static variables below are used to drive control flow in the source functions.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodG2B1_public_static = false;
    public static boolean goodG2B2_public_static = false;

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    private void goodG2B1() throws Throwable
    {
        String data;

        goodG2B1_public_static = false;
        data = (new CWE321_Hard_Coded_Cryptographic_Key__basic_22b()).goodG2B1_source();

        if (data != null)
        {
            String sToEncrypt = "Super secret Squirrel";
            byte[] bToEncrypt = sToEncrypt.getBytes("UTF-8");
            /* POTENTIAL FLAW: Use data as a cryptographic key */
            SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes("UTF-8"), "AES");
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
            byte[] bCipherText = aesCipher.doFinal(bToEncrypt);
            IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */
        }

    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    private void goodG2B2() throws Throwable
    {
        String data;

        goodG2B2_public_static = true;
        data = (new CWE321_Hard_Coded_Cryptographic_Key__basic_22b()).goodG2B2_source();

        if (data != null)
        {
            String sToEncrypt = "Super secret Squirrel";
            byte[] bToEncrypt = sToEncrypt.getBytes("UTF-8");
            /* POTENTIAL FLAW: Use data as a cryptographic key */
            SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes("UTF-8"), "AES");
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
            byte[] bCipherText = aesCipher.doFinal(bToEncrypt);
            IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */
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
