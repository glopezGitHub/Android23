/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__getCookies_Servlet_22b.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : read line from file from disk
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__getCookies_Servlet_22b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE36_Absolute_Path_Traversal__getCookies_Servlet_22a.bad_public_static)
        {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE36_Absolute_Path_Traversal__getCookies_Servlet_22a.goodG2B1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE36_Absolute_Path_Traversal__getCookies_Servlet_22a.goodG2B2_public_static)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        return data;
    }
}
