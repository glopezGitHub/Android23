/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__base64_encoded_payload_15.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: base64_encoded_payload
*    GoodSink: Use a plaintext command
*    BadSink : Use a base64 encoded payload in an attempt to hide the command
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.logging.Level;

import org.apache.commons.codec.binary.Base64;

public class CWE506_Embedded_Malicious_Code__base64_encoded_payload_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        break;
        default:
        {
            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        break;
        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
