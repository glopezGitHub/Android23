/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_53c.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_53c
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_53d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_53d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_53d()).goodB2G_sink(data );
    }
}
