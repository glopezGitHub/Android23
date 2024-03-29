/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_81_base.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: driverManager
 *    BadSink : data used as password in database connection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public abstract class CWE259_Hard_Coded_Password__driverManager_81_base
{

    public abstract void action(String data ) throws Throwable;

}
