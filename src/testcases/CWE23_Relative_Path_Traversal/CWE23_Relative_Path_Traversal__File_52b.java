/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__File_52b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__File_52b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__File_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__File_52c()).goodG2B_sink(data );
    }

}
