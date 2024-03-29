/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__getCookies_Servlet_81_base.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public abstract class CWE23_Relative_Path_Traversal__getCookies_Servlet_81_base
{

    public abstract void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable;

}
