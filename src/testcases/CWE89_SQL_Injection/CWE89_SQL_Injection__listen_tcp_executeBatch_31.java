/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__listen_tcp_executeBatch_31.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
 * Flow Variant: 31 Data flow: make a copy of data within the same method
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
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__listen_tcp_executeBatch_31 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data_copy;
        {
            String data;

            data = ""; /* Initialize data */

            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;

                try {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();

                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
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

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            if (data != null)
            {
                String names[] = data.split("-");
                int iSuccess = 0;
                Connection conn_tmp2 = null;
                Statement sqlstatement = null;
                try
                {
                    conn_tmp2 = IO.getDBConnection();
                    sqlstatement = conn_tmp2.createStatement();
                    for(int i = 0; i < names.length; ++i)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statment used in executeBatch(), which could result in SQL Injection */
                        sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                    }
                    int dbResults[] = sqlstatement.executeBatch();
                    for( int i = 0; i < names.length; ++i )
                    {
                        if( dbResults[i] > 0 )
                        {
                            iSuccess++;
                        }
                    }
                    IO.writeLine("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", se);
                }
                finally
                {
                    try {
                        if( sqlstatement != null )
                        {
                            sqlstatement.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statament", e);
                    }
                    finally {
                        try {
                            if( conn_tmp2 != null )
                            {
                                conn_tmp2.close();
                            }
                        }
                        catch( SQLException e )
                        {
                            IO.logger.log(Level.WARNING, "Error closing Connection", e);
                        }
                    }
                }
            }

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

            /* FIX: Use a hardcoded string */
            data = "foo";

            data_copy = data;
        }
        {
            String data = data_copy;

            if (data != null)
            {
                String names[] = data.split("-");
                int iSuccess = 0;
                Connection conn_tmp2 = null;
                Statement sqlstatement = null;
                try
                {
                    conn_tmp2 = IO.getDBConnection();
                    sqlstatement = conn_tmp2.createStatement();
                    for(int i = 0; i < names.length; ++i)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statment used in executeBatch(), which could result in SQL Injection */
                        sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                    }
                    int dbResults[] = sqlstatement.executeBatch();
                    for( int i = 0; i < names.length; ++i )
                    {
                        if( dbResults[i] > 0 )
                        {
                            iSuccess++;
                        }
                    }
                    IO.writeLine("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", se);
                }
                finally
                {
                    try {
                        if( sqlstatement != null )
                        {
                            sqlstatement.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statament", e);
                    }
                    finally {
                        try {
                            if( conn_tmp2 != null )
                            {
                                conn_tmp2.close();
                            }
                        }
                        catch( SQLException e )
                        {
                            IO.logger.log(Level.WARNING, "Error closing Connection", e);
                        }
                    }
                }
            }

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data_copy;
        {
            String data;

            data = ""; /* Initialize data */

            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;

                try {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();

                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
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

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            if (data != null)
            {
                String names[] = data.split("-");
                int iSuccess = 0;
                Connection conn_tmp2 = null;
                PreparedStatement sqlstatement = null;
                try
                {
                    /* FIX: Use prepared statement and executeBatch (properly) */
                    conn_tmp2 = IO.getDBConnection();
                    sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                    for(int i = 0; i < names.length; ++i)
                    {
                        sqlstatement.setString(1, names[i]);
                        sqlstatement.addBatch();
                    }
                    int dbResults[] = sqlstatement.executeBatch();
                    for( int i = 0; i < names.length; ++i )
                    {
                        if( dbResults[i] > 0 )
                        {
                            iSuccess++;
                        }
                    }
                    IO.writeLine("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", se);
                }
                finally
                {
                    try {
                        if( sqlstatement != null )
                        {
                            sqlstatement.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }
                    finally {
                        try {
                            if( conn_tmp2 != null )
                            {
                                conn_tmp2.close();
                            }
                        }
                        catch( SQLException e )
                        {
                            IO.logger.log(Level.WARNING, "Error closing Connection", e);
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
