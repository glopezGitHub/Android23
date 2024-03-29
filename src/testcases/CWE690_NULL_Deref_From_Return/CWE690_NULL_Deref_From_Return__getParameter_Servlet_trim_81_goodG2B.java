/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__getParameter_Servlet_trim_81_goodG2B.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: getParameter_Servlet Set data to return of getParameter_Servlet
 * GoodSource: Set data to fixed, non-null String
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__getParameter_Servlet_trim_81_goodG2B extends CWE690_NULL_Deref_From_Return__getParameter_Servlet_trim_81_base
{

    public void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.trim();

        IO.writeLine(sOut);

    }

}
