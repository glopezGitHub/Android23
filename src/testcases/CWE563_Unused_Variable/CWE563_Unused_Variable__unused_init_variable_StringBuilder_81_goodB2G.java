/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_StringBuilder_81_goodB2G.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 563 Unused Variable
 * BadSource:  Initialize data
 * Sinks:
 *    GoodSink: Use data
 *    BadSink : do nothing
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_init_variable_StringBuilder_81_goodB2G extends CWE563_Unused_Variable__unused_init_variable_StringBuilder_81_base
{

    public void action(StringBuilder data ) throws Throwable
    {

        /* FIX: Use data */
        IO.writeLine(data.toString());

    }

}
