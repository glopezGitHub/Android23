/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_equals_81_goodB2G.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_equals_81_goodB2G extends CWE690_NULL_Deref_From_Return__System_getProperty_equals_81_base
{

    public void action(String data ) throws Throwable
    {

        /* FIX: call equals() on string literal (that is not null) */
        if("CWE690".equals(data))
        {
            IO.writeLine("data is CWE690");
        }

    }

}
