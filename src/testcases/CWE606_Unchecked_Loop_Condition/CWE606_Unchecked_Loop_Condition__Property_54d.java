/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__Property_54d.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: Property Read data from a system property
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__Property_54d
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE606_Unchecked_Loop_Condition__Property_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE606_Unchecked_Loop_Condition__Property_54e()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE606_Unchecked_Loop_Condition__Property_54e()).goodB2G_sink(data );
    }
}
