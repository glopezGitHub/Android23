/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__CWE182_getCookies_Servlet_73b.java
Label Definition File: CWE80_XSS__CWE182.label.xml
Template File: sources-sink-73b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS (CWE 182: Collapse of Data into Unsafe Value)
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE80_XSS__CWE182_getCookies_Servlet_73b
{

    public void bad_sink(LinkedList<String> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS with strings like <scr<script>ipt> (CWE 182: Collapse of Data into Unsafe Value) */
            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(LinkedList<String> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS with strings like <scr<script>ipt> (CWE 182: Collapse of Data into Unsafe Value) */
            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
        }

    }

}