/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_73a.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;
import java.util.LinkedList;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_73a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        LinkedList<StringBuilder> data_linkedlist = new LinkedList<StringBuilder>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE476_NULL_Pointer_Dereference__StringBuilder_73b()).bad_sink(data_linkedlist  );
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

        LinkedList<StringBuilder> data_linkedlist = new LinkedList<StringBuilder>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE476_NULL_Pointer_Dereference__StringBuilder_73b()).goodG2B_sink(data_linkedlist  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        LinkedList<StringBuilder> data_linkedlist = new LinkedList<StringBuilder>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE476_NULL_Pointer_Dereference__StringBuilder_73b()).goodB2G_sink(data_linkedlist  );
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
