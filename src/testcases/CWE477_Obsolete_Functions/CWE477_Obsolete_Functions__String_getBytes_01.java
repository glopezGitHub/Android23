/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_01.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of preferred java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__String_getBytes_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        String s2bytes = "Convert this to bytes";
        byte[] bytes = new byte[s2bytes.length()];

        /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
        s2bytes.getBytes(0, s2bytes.length(), bytes, 0);

        IO.writeLine(IO.toHex(bytes)); /* Use bytes */

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        String s2bytes = "Convert this to bytes";

        /* FIX: Use preferred String.getBytes() method */
        byte[] bytes = s2bytes.getBytes("UTF-8");

        IO.writeLine(IO.toHex(bytes)); /* Use bytes */

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

