/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_08.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of preferred java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__String_getBytes_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
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

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
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
        if(private_returns_t())
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
