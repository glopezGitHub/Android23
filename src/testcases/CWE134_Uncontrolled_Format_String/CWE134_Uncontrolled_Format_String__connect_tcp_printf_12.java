/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__connect_tcp_printf_12.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: printf
*    GoodSink: dynamic printf format with string defined
*    BadSink : dynamic printf without validation
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE134_Uncontrolled_Format_String__connect_tcp_printf_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            data = ""; /* Initialize data */
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
                    data = buffread.readLine();
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
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_returns_t_or_f())
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
        }
        else {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_returns_t_or_f())
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }
        }
        else {

            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.printf(data);
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            data = ""; /* Initialize data */
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
                    data = buffread.readLine();
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
        }
        else {

            data = ""; /* Initialize data */

            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);

                    /* read input from socket */

                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
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

        }
        if(IO.static_returns_t_or_f())
        {
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
            }
        }
        else {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.printf("%s%n", data);
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
