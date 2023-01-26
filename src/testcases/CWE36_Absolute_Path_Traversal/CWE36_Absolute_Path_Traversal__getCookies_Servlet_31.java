/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__getCookies_Servlet_31.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE36_Absolute_Path_Traversal__getCookies_Servlet_31 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            data = ""; /* initialize data in case there are no cookies */

            /* Read data from cookies */
            {
                Cookie cookieSources[] = request.getCookies();
                if (cookieSources != null)
                {
                    /* POTENTIAL FLAW: Read data from the first cookie value */
                    data = cookieSources[0].getValue();
                }
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            /* POTENTIAL FLAW: unvalidated or sandboxed value */
            if (data != null)
            {
                File fIn = new File(data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            /* FIX: Use a hardcoded string */
            data = "foo";

            data_copy = data;
        }
        {
            String data = data_copy;

            /* POTENTIAL FLAW: unvalidated or sandboxed value */
            if (data != null)
            {
                File fIn = new File(data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
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
