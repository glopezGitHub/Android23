/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_31.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_31 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data_copy;
        {
            String data;

            FileInputStream finstrm2 = null;
            String propFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
            try
            {
                finstrm2 = new FileInputStream(propFileName);
                Properties p = new Properties();
                p.load(finstrm2);

                /* POTENTIAL FLAW: data may be set to null */
                data = p.getProperty("CWE690");
            }
            catch( IOException ioe )
            {
                IO.writeLine("Could not open properties file: " + propFileName);
                data = ""; /* ensure that data is initialized */
            }
            finally
            {
                try
                {
                    if( finstrm2 != null )
                    {
                        finstrm2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
                }
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data_copy;
        {
            String data;

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

            data_copy = data;
        }
        {
            String data = data_copy;

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data_copy;
        {
            String data;

            FileInputStream finstrm2 = null;
            String propFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
            try
            {
                finstrm2 = new FileInputStream(propFileName);
                Properties p = new Properties();
                p.load(finstrm2);

                /* POTENTIAL FLAW: data may be set to null */
                data = p.getProperty("CWE690");
            }
            catch( IOException ioe )
            {
                IO.writeLine("Could not open properties file: " + propFileName);
                data = ""; /* ensure that data is initialized */
            }
            finally
            {
                try
                {
                    if( finstrm2 != null )
                    {
                        finstrm2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
                }
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

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
