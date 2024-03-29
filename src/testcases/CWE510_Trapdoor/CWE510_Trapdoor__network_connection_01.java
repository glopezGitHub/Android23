/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE510_Trapdoor__network_connection_01.java
Label Definition File: CWE510_Trapdoor.badonly.label.xml
Template File: point-flaw-badonly-01.tmpl.java
*/
/*
* @description
* CWE: 510 Trapdoor
* Sinks: network_connection
*    BadSink : Presence of a network connection
*	 BadOnly (No GoodSink)
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE510_Trapdoor;

import testcasesupport.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.logging.Level;

public class CWE510_Trapdoor__network_connection_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        InputStream instream = null;
        try
        {
            /* FLAW: direct usage of URI */
            URL u = new URL("http://123.123.123.123:80");
            instream = u.openStream();
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "caught IOException", e);
        }
        finally
        {
            try
            {
                if (instream != null)
                {
                    instream.close();
                }
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "caught IOException", e);
            }
        }

    }

    public void good() throws Throwable
    {
        /* DO NOTHING - BadOnly test case */
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

