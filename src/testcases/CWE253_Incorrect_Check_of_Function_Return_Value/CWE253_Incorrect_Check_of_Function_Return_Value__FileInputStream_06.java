/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE253_Incorrect_Check_of_Function_Return_Value__FileInputStream_06.java
Label Definition File: CWE253_Incorrect_Check_of_Function_Return_Value__FileInputStream.label.xml
Template File: point-flaw-06.tmpl.java
*/
/*
* @description
* CWE: 253 Incorrect Check of Function Return Value
* Sinks:
*    GoodSink: Check the return value from FileInputStream.read() and handle possible errors
*    BadSink : Check the return value of FileInputStream.read() for the wrong value
* Flow Variant: 06 Control flow: if(private_final_five==5) and if(private_final_five!=5)
*
* */

package testcases.CWE253_Incorrect_Check_of_Function_Return_Value;

import testcasesupport.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE253_Incorrect_Check_of_Function_Return_Value__FileInputStream_06 extends AbstractTestCase
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad() throws Throwable
    {
        if (private_final_five==5)
        {
            FileInputStream fis = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                fis = new FileInputStream("c:\\file.txt");
                /* FLAW: Incorrect check on result of read().  Should check if the return value is -1 or is less than bytesToRead. */
                if(fis.read(byteArray) == 0)
                {
                    IO.writeLine("Error reading file.");
                }
                else
                {
                    IO.writeLine(new String(byteArray, "UTF-8"));
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                int numberOfBytesRead = fis.read(byteArray);

                /* FIX: Check the return value of read() and handle possible errors */
                if (numberOfBytesRead == -1)
                {
                    IO.writeLine("The end of the file has been reached.");
                }
                else {
                    if (numberOfBytesRead < bytesToRead)
                    {
                        IO.writeLine("Could not read " + bytesToRead + " bytes.");
                    }
                    else {
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
            finally {
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

        }
    }

    /* good1() changes private_final_five==5 to private_final_five!=5 */
    private void good1() throws Throwable
    {
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            FileInputStream fis = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                fis = new FileInputStream("c:\\file.txt");
                /* FLAW: Incorrect check on result of read().  Should check if the return value is -1 or is less than bytesToRead. */
                if(fis.read(byteArray) == 0)
                {
                    IO.writeLine("Error reading file.");
                }
                else
                {
                    IO.writeLine(new String(byteArray, "UTF-8"));
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
        }
        else {

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                int numberOfBytesRead = fis.read(byteArray);

                /* FIX: Check the return value of read() and handle possible errors */
                if (numberOfBytesRead == -1)
                {
                    IO.writeLine("The end of the file has been reached.");
                }
                else {
                    if (numberOfBytesRead < bytesToRead)
                    {
                        IO.writeLine("Could not read " + bytesToRead + " bytes.");
                    }
                    else {
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
            finally {
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

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_five==5)
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                /* FLAW: Incorrect check on result of read().  Should check if the return value is -1 or is less than bytesToRead. */
                if(fis.read(byteArray) == 0)
                {
                    IO.writeLine("Error reading file.");
                }
                else {
                    IO.writeLine(new String(byteArray, "UTF-8"));
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
            finally {
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
