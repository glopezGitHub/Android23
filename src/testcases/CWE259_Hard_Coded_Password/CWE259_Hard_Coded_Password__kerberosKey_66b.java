/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__kerberosKey_66b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-66b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: kerberosKey
 *    BadSink : data used as password in KerberosKey()
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
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

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

public class CWE259_Hard_Coded_Password__kerberosKey_66b
{

    public void bad_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        if (data != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal("test");
            /* POTENTIAL FLAW: data used as password in KerberosKey() */
            KerberosKey key = new KerberosKey(principal, data.toCharArray(), null);
            IO.writeLine(key.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        if (data != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal("test");
            /* POTENTIAL FLAW: data used as password in KerberosKey() */
            KerberosKey key = new KerberosKey(principal, data.toCharArray(), null);
            IO.writeLine(key.toString());
        }

    }

}
