/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_68b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: kerberosKey
 *    GoodSink: Decrypt password before using in KerberosKey()
 *    BadSink : Use password directly in KerberosKey()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_68b
{

    public void bad_sink() throws Throwable
    {
        String password = CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_68a.password;

        if (password != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal("test");
            /* POTENTIAL FLAW: Use password directly in KerberosKey() */
            KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
            IO.writeLine(key.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String password = CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_68a.password;

        if (password != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal("test");
            /* POTENTIAL FLAW: Use password directly in KerberosKey() */
            KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
            IO.writeLine(key.toString());
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        String password = CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_68a.password;

        if (password != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal("test");
            /* FIX: Decrypt password before using in KerberosKey() */
            {
                Cipher aes = Cipher.getInstance("AES");
                KeyGenerator kg = KeyGenerator.getInstance("AES");
                kg.init(128);
                /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes.init(Cipher.DECRYPT_MODE, keySpec);
                password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
            }
            KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
            IO.writeLine(key.toString());
        }

    }
}
