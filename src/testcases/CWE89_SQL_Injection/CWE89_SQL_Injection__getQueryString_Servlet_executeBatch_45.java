/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getQueryString_Servlet_executeBatch_45.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;
import java.util.StringTokenizer;

public class CWE89_SQL_Injection__getQueryString_Servlet_executeBatch_45 extends AbstractTestCaseServlet
{

    private String bad_data;
    private String goodG2B_data;
    private String goodB2G_data;

    private void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_data;

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

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        bad_data = data;
        bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_data;

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

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_data = data;
        goodG2B_sink(request, response);
    }

    private void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodB2G_data;

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        goodB2G_data = data;
        goodB2G_sink(request, response);
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