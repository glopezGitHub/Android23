/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE481_Assigning_Instead_of_Comparing__basic_04.java
Label Definition File: CWE481_Assigning_Instead_of_Comparing__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 481 Assigning Instead of Comparing
* Sinks:
*    GoodSink: Comparing
*    BadSink : Assigning instead of comparing
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE481_Assigning_Instead_of_Comparing;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE481_Assigning_Instead_of_Comparing__basic_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = (i == 0);

            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = (i == 0);

            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = (i == 0);

            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

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
