/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__console_readLine_write_12.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: console_readLine Read count from the console using readLine
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: write
*    GoodSink: Write to a file count number of times, but first validate count
*    BadSink : Write to a file count number of times
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__console_readLine_write_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;
        if(IO.static_returns_t_or_f())
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read count from the console using readLine */
                String s_count = buffread.readLine();
                if (s_count != null)  // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(s_count.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            File file = new File("badSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;
            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }
            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }
            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }
        }
        else {

            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter buffwrite = new BufferedWriter(oswrite);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        buffwrite.write("Hello");
                    }
                    catch (IOException ioe)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                    }
                }
                /* Close stream reading objects */
                try
                {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }
                try
                {
                    if( oswrite != null )
                    {
                        oswrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }
                try
                {
                    if( fos != null )
                    {
                        fos.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        int count;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            File file = new File("badSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;
            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }
            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }
            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }
        }
        else {

            File file = new File("badSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;

            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }

            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }

            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }

            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;
        if(IO.static_returns_t_or_f())
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read count from the console using readLine */
                String s_count = buffread.readLine();
                if (s_count != null)  // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(s_count.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {

            count = Integer.MIN_VALUE; /* Initialize count */

            /* read user input from console with readLine */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* POTENTIAL FLAW: Read count from the console using readLine */
                String s_count = buffread.readLine();
                if (s_count != null)  // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(s_count.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                    }
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter buffwrite = new BufferedWriter(oswrite);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        buffwrite.write("Hello");
                    }
                    catch (IOException ioe)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                    }
                }
                /* Close stream reading objects */
                try
                {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }
                try
                {
                    if( oswrite != null )
                    {
                        oswrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }
                try
                {
                    if( fos != null )
                    {
                        fos.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
        }
        else {

            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter buffwrite = new BufferedWriter(oswrite);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        buffwrite.write("Hello");
                    }
                    catch (IOException ioe)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                    }
                }
                /* Close stream reading objects */
                try
                {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }
                try
                {
                    if( oswrite != null )
                    {
                        oswrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }
                try
                {
                    if( fos != null )
                    {
                        fos.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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