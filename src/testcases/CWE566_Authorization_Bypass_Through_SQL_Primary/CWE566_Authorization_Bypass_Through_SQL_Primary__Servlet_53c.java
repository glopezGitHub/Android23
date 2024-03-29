/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_53c.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    BadSink : user authorization not checked
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_53d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_53d()).goodG2B_sink(data , request, response);
    }

}
