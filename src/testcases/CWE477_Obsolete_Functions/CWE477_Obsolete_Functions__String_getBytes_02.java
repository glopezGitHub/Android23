/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_02.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of preferred java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__String_getBytes_02 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (true)
        {
            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length(), bytes, 0);
            IO.writeLine(IO.toHex(bytes)); /* Use bytes */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String s2bytes = "Convert this to bytes";

            /* FIX: Use preferred String.getBytes() method */
            byte[] bytes = s2bytes.getBytes("UTF-8");

            IO.writeLine(IO.toHex(bytes)); /* Use bytes */

        }
    }

    /* good1() changes true to false */
    private void good1() throws Throwable
    {
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length(), bytes, 0);
            IO.writeLine(IO.toHex(bytes)); /* Use bytes */
        }
        else {

            String s2bytes = "Convert this to bytes";

            /* FIX: Use preferred String.getBytes() method */
            byte[] bytes = s2bytes.getBytes("UTF-8");

            IO.writeLine(IO.toHex(bytes)); /* Use bytes */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(true)
        {
            String s2bytes = "Convert this to bytes";
            /* FIX: Use preferred String.getBytes() method */
            byte[] bytes = s2bytes.getBytes("UTF-8");
            IO.writeLine(IO.toHex(bytes)); /* Use bytes */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];

            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length(), bytes, 0);

            IO.writeLine(IO.toHex(bytes)); /* Use bytes */

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
