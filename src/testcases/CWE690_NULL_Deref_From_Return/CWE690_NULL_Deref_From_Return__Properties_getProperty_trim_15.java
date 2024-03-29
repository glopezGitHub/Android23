/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_15.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource: Properties_getProperty Set data to return of Properties.getProperty
* GoodSource: Set data to fixed, non-null String
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 15 Control flow: switch(6) and switch(7)
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

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_trim_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
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
        }
        break;
        default:
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
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
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        break;
        default:
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
