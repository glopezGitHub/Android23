/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_21.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-21.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  Set data to a hardcoded value
 * GoodSource: Read data from the console using readLine()
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : Use data as a cryptographic key
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
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

public class CWE321_Hard_Coded_Cryptographic_Key__basic_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the source function */
    private boolean bad_private = false;

    public void bad() throws Throwable
    {
        String data;

        bad_private = true;
        data = bad_source();

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

    private String bad_source() throws Throwable
    {
        String data;

        if(bad_private)
        {
            /* FLAW: Set data to a hardcoded value */
            data = "23 ~j;asn!@#/>as";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* read user input from console with readLine */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* FIX: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        return data;
    }

    /* The variables below are used to drive control flow in the source functions. */
    private boolean goodG2B1_private = false;
    private boolean goodG2B2_private = false;

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }

    /* goodG2B1() - use goodsource and badsink by setting the variable to false instead of true */
    private void goodG2B1() throws Throwable
    {
        String data;

        goodG2B1_private = false;
        data = goodG2B1_source();

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

    private String goodG2B1_source() throws Throwable
    {
        String data;

        if(goodG2B1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Set data to a hardcoded value */
            data = "23 ~j;asn!@#/>as";
        }
        else {

            data = ""; /* Initialize data */

            /* read user input from console with readLine */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* FIX: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    private void goodG2B2() throws Throwable
    {
        String data;

        goodG2B2_private = true;
        data = goodG2B2_source();

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

    private String goodG2B2_source() throws Throwable
    {
        String data;

        if(goodG2B2_private)
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* FIX: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Set data to a hardcoded value */
            data = "23 ~j;asn!@#/>as";

        }
        return data;
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
