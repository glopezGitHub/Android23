/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE482_Comparing_Instead_of_Assigning__basic_12.java
Label Definition File: CWE482_Comparing_Instead_of_Assigning__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 482 Comparing Instead of Assigning
* Sinks:
*    GoodSink: Assigning
*    BadSink : Comparing instead of assigning
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE482_Comparing_Instead_of_Assigning;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE482_Comparing_Instead_of_Assigning__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = false;
            if((isZero == (i == 0)) == true) /* FLAW: should be (isZero = (i == 0)) */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = false;

            if((isZero = (i == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = false;
            if((isZero = (i == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = false;

            if((isZero = (i == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    public void good() throws Throwable
    {
        good1();
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
