/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__URLConnection_74a.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;
import java.util.HashMap;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE760_Predictable_Salt_One_Way_Hash__URLConnection_74a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                }

                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        HashMap<Integer,String> data_hashmap = new HashMap<Integer,String>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE760_Predictable_Salt_One_Way_Hash__URLConnection_74b()).bad_sink(data_hashmap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        HashMap<Integer,String> data_hashmap = new HashMap<Integer,String>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE760_Predictable_Salt_One_Way_Hash__URLConnection_74b()).goodG2B_sink(data_hashmap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                }

                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        HashMap<Integer,String> data_hashmap = new HashMap<Integer,String>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE760_Predictable_Salt_One_Way_Hash__URLConnection_74b()).goodB2G_sink(data_hashmap  );
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