/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_66a.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-66a.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  Set data to a hardcoded value
 * GoodSource: Read data from the console using readLine()
 * Sinks:
 *    BadSink : Use data as a cryptographic key
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
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

public class CWE321_Hard_Coded_Cryptographic_Key__basic_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* FLAW: Set data to a hardcoded value */
        data = "23 ~j;asn!@#/>as";

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE321_Hard_Coded_Cryptographic_Key__basic_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

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

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE321_Hard_Coded_Cryptographic_Key__basic_66b()).goodG2B_sink(data_array  );
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
