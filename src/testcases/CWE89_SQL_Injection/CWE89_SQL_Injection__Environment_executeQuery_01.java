/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_executeQuery_01.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded string
* Sinks: executeQuery
*    GoodSink: Use prepared statement and executeQuery (properly)
*    BadSink : data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__Environment_executeQuery_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection */
            sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");

            IO.writeLine(sqlrs.getRow()); /* Use ResultSet in some way */
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", e);
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

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection */
            sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");

            IO.writeLine(sqlrs.getRow()); /* Use ResultSet in some way */
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", e);
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
    private void goodB2G() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            /* FIX: Use prepared statement and executeQuery (properly) */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
            sqlstatement.setString(1, data);

            sqlrs = sqlstatement.executeQuery();

            IO.writeLine(sqlrs.getRow()); /* Use ResultSet in some way */
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatment", e);
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

