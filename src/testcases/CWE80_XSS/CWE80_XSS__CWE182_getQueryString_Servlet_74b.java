/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__CWE182_getQueryString_Servlet_74b.java
Label Definition File: CWE80_XSS__CWE182.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS (CWE 182: Collapse of Data into Unsafe Value)
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE80_XSS__CWE182_getQueryString_Servlet_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS with strings like <scr<script>ipt> (CWE 182: Collapse of Data into Unsafe Value) */
            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS with strings like <scr<script>ipt> (CWE 182: Collapse of Data into Unsafe Value) */
            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
        }

    }

}
