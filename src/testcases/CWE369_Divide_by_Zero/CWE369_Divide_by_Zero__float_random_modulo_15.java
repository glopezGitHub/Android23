/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_random_modulo_15.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: random Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive)
* GoodSource: A hardcoded non-zero number (two)
* Sinks: modulo
*    GoodSink: Check for zero before modulo
*    BadSink : Modulo by a value that may be zero
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_random_modulo_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        float data;
        switch(6)
        {
        case 6:
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        float data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        break;
        default:
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        float data;
        switch(6)
        {
        case 6:
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        float data;
        switch(6)
        {
        case 6:
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        break;
        default:
        {
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        float data;
        switch(6)
        {
        case 6:
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
