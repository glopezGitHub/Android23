/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE252_Unchecked_Return_Value__FileInputStream_16.java
Label Definition File: CWE252_Unchecked_Return_Value__FileInputStream.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 252 Unchecked Return Value
* Sinks:
*    GoodSink: Check the return value from FileInputStream.read() and handle possible errors
*    BadSink : Do not check the return value of FileInputStream.read()
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE252_Unchecked_Return_Value;

import testcasesupport.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE252_Unchecked_Return_Value__FileInputStream_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            FileInputStream fis = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                fis = new FileInputStream("c:\\file.txt");
                fis.read(byteArray);
                /* FLAW: Do not check the return value of read() */
                IO.writeLine(new String(byteArray, "UTF-8"));
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally
            {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            FileInputStream fis = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                fis = new FileInputStream("c:\\file.txt");
                int numberOfBytesRead = fis.read(byteArray);
                /* FIX: Check the return value of read() and handle possible errors */
                if (numberOfBytesRead == -1)
                {
                    IO.writeLine("The end of the file has been reached.");
                }
                else
                {
                    if (numberOfBytesRead < bytesToRead)
                    {
                        IO.writeLine("Could not read " + bytesToRead + " bytes.");
                    }
                    else
                    {
                        IO.writeLine(new String(byteArray, "UTF-8"));
                    }
                }
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally
            {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }
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
            FileInputStream fis = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                fis = new FileInputStream("c:\\file.txt");
                fis.read(byteArray);
                /* FLAW: Do not check the return value of read() */
                IO.writeLine(new String(byteArray, "UTF-8"));
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally
            {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }
            break;
        }

        while(true)
        {
            FileInputStream fis = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                fis = new FileInputStream("c:\\file.txt");
                int numberOfBytesRead = fis.read(byteArray);
                /* FIX: Check the return value of read() and handle possible errors */
                if (numberOfBytesRead == -1)
                {
                    IO.writeLine("The end of the file has been reached.");
                }
                else
                {
                    if (numberOfBytesRead < bytesToRead)
                    {
                        IO.writeLine("Could not read " + bytesToRead + " bytes.");
                    }
                    else
                    {
                        IO.writeLine(new String(byteArray, "UTF-8"));
                    }
                }
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally
            {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }
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