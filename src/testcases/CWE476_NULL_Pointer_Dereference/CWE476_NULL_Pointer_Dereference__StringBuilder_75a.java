/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_75a.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-75a.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_75a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE476_NULL_Pointer_Dereference__StringBuilder_75b()).bad_sink(data_serialized  );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;

        /* FIX: hardcode data to non-null */
        data = new StringBuilder();

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE476_NULL_Pointer_Dereference__StringBuilder_75b()).goodG2B_sink(data_serialized  );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE476_NULL_Pointer_Dereference__StringBuilder_75b()).goodB2G_sink(data_serialized  );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
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