/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__File_executeQuery_52a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-52a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: Use prepared statement and executeQuery (properly)
 *    BadSink : data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__File_executeQuery_52a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */
        {
            File f = new File("C:\\data.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader buffread = null;

            try {
                /* read string from file into data */
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                buffread = new BufferedReader(isread);

                /* POTENTIAL FLAW: Read data from a file */
                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* Close stream reading objects */
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
                    if( isread != null )
                    {
                        isread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                try {
                    if( fis != null )
                    {
                        fis.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }
        }

        (new CWE89_SQL_Injection__File_executeQuery_52b()).bad_sink(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE89_SQL_Injection__File_executeQuery_52b()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */
        {
            File f = new File("C:\\data.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader buffread = null;

            try {
                /* read string from file into data */
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                buffread = new BufferedReader(isread);

                /* POTENTIAL FLAW: Read data from a file */
                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* Close stream reading objects */
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
                    if( isread != null )
                    {
                        isread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                try {
                    if( fis != null )
                    {
                        fis.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }
        }

        (new CWE89_SQL_Injection__File_executeQuery_52b()).goodB2G_sink(data );
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
