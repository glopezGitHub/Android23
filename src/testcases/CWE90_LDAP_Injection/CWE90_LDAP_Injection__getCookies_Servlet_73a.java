/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getCookies_Servlet_73a.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-73a.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;
import java.util.LinkedList;

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.http.*;

import java.util.Hashtable;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__getCookies_Servlet_73a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        LinkedList<String> data_linkedlist = new LinkedList<String>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE90_LDAP_Injection__getCookies_Servlet_73b()).bad_sink(data_linkedlist , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        LinkedList<String> data_linkedlist = new LinkedList<String>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE90_LDAP_Injection__getCookies_Servlet_73b()).goodG2B_sink(data_linkedlist , request, response );
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
