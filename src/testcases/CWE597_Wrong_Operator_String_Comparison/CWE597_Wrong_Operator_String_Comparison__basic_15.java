/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE597_Wrong_Operator_String_Comparison__basic_15.java
Label Definition File: CWE597_Wrong_Operator_String_Comparison__basic.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 597 Use of '==' instead of 'equals()' to test String equivalence
* Sinks:
*    GoodSink: Correctly use .equals() to compare strings
*    BadSink : Use == operator instead of .equals() to compare strings
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE597_Wrong_Operator_String_Comparison;

import testcasesupport.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE597_Wrong_Operator_String_Comparison__basic_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison results */
                    if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                    {
                        System.out.println("bad(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("bad(): Strings are not equal"); /* This will always display */
                    }
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison */
                    if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                    {
                        System.out.println("good(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("good(): Strings are not equal");
                    }
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
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
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison results */
                    if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                    {
                        System.out.println("bad(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("bad(): Strings are not equal"); /* This will always display */
                    }
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
            }
        }
        break;
        default:
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison */
                    if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                    {
                        System.out.println("good(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("good(): Strings are not equal");
                    }
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
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
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison */
                    if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                    {
                        System.out.println("good(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("good(): Strings are not equal");
                    }
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison results */
                    if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                    {
                        System.out.println("bad(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("bad(): Strings are not equal"); /* This will always display */
                    }
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
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
