/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__listen_tcp_81_goodG2B.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__listen_tcp_81_goodG2B extends CWE606_Unchecked_Loop_Condition__listen_tcp_81_base
{

    public void action(String data ) throws Throwable
    {

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        for(int i=0; i < loopNum; i++)
        {
            /* POTENTIAL FLAW: user supplied input used for loop counter test */
            IO.writeLine("hello world");
        }

    }

}
