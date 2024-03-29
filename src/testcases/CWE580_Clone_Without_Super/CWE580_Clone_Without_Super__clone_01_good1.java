/*
 * @description A class defines clone() but does not call super.clone().
 * 
 * This is the "good" version, which has a clone() that does call super.clone().
 * 
 * */

package testcases.CWE580_Clone_Without_Super;

import java.util.Date;
import testcasesupport.*;

public class CWE580_Clone_Without_Super__clone_01_good1 extends AbstractTestCaseClassIssueGood 
{
	/* Just to have something to do in clone() other than return the object */
	private Date testdate = new Date();

    public void setDate(Date d) {
		testdate = (Date) d.clone();
    }
		
	protected final Object clone() throws CloneNotSupportedException {
		/* FIX: super.clone() is called */
		CWE580_Clone_Without_Super__clone_01_good1 obj = (CWE580_Clone_Without_Super__clone_01_good1) super.clone();		  
		obj.setDate(new Date(testdate.getTime()));
		return obj;
    }
	
	public void good1() throws CloneNotSupportedException
    { 
		/* Use the clone method */
		CWE580_Clone_Without_Super__clone_01_good1 myClone = (CWE580_Clone_Without_Super__clone_01_good1)clone();

        myClone.setDate(new Date());
    }
	
	public void good() throws CloneNotSupportedException
    {
        good1();
	}
}
