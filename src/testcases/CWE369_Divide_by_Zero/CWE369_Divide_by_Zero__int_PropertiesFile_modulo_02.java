/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_PropertiesFile_modulo_02.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-02.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: modulo
*    GoodSink: Check for zero before modulo
*    BadSink : Modulo by a value that may be zero
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__int_PropertiesFile_modulo_02 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                /* POTENTIAL FLAW: Read data from a .properties file */
                String s_data = props.getProperty("data");
                if (s_data != null)   // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
                /* Close stream reading object */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: test for a zero modulus */
            if( data != 0 )
            {
                IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first true to false */
    private void goodG2B1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = Integer.MIN_VALUE; /* Initialize data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                /* POTENTIAL FLAW: Read data from a .properties file */
                String s_data = props.getProperty("data");
                if (s_data != null)   // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
                /* Close stream reading object */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: test for a zero modulus */
            if( data != 0 )
            {
                IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = Integer.MIN_VALUE; /* Initialize data */

            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);

                /* POTENTIAL FLAW: Read data from a .properties file */
                String s_data = props.getProperty("data");
                if (s_data != null)   // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* Close stream reading object */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: test for a zero modulus */
            if( data != 0 )
            {
                IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second true to false */
    private void goodB2G1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                /* POTENTIAL FLAW: Read data from a .properties file */
                String s_data = props.getProperty("data");
                if (s_data != null)   // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
                /* Close stream reading object */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {

            /* FIX: test for a zero modulus */
            if( data != 0 )
            {
                IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                /* POTENTIAL FLAW: Read data from a .properties file */
                String s_data = props.getProperty("data");
                if (s_data != null)   // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
                /* Close stream reading object */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* FIX: test for a zero modulus */
            if( data != 0 )
            {
                IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

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
