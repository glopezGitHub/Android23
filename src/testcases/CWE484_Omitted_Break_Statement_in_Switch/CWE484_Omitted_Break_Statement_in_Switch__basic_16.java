/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement_in_Switch__basic_16.java
Label Definition File: CWE484_Omitted_Break_Statement_in_Switch__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement in Switch
* Sinks:
*    GoodSink: Each case in switch has a break statement
*    BadSink : Missing break statement in one case of switch
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE484_Omitted_Break_Statement_in_Switch;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE484_Omitted_Break_Statement_in_Switch__basic_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two"; /* INCIDENTAL: CWE563 Unused Variable (actually unused value) since s gets overwritten in the default case */
                /* FLAW: Case 2 is missing a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two"; /* INCIDENTAL: CWE563 Unused Variable (actually unused value) since s gets overwritten in the default case */
                /* FLAW: Case 2 is missing a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
            break;
        }

        while(true)
        {
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
            break;
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