/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_connect_tcp_sub_16.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE191_Integer_Underflow__int_connect_tcp_sub_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while(true)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    String s_data = buffread.readLine();
                    if (s_data != null)  // avoid NPD incidental warnings
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

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        int data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = Integer.MIN_VALUE; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    String s_data = buffread.readLine();
                    if (s_data != null)  // avoid NPD incidental warnings
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

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        int data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while(true)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    String s_data = buffread.readLine();
                    if (s_data != null)  // avoid NPD incidental warnings
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

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
            break;
        }

        while(true)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
            break;
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
