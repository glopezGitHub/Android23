/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__PropertiesFile_54b.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-54b.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.http.*;

import java.util.Hashtable;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE90_LDAP_Injection__PropertiesFile_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE90_LDAP_Injection__PropertiesFile_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE90_LDAP_Injection__PropertiesFile_54c()).goodG2B_sink(data );
    }

}
