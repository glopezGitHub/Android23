/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__Property_71a.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-71a.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__Property_71a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        (new CWE36_Absolute_Path_Traversal__Property_71b()).bad_sink((Object)data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE36_Absolute_Path_Traversal__Property_71b()).goodG2B_sink((Object)data  );
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
