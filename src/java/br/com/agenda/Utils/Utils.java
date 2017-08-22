/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Destroyer
 */
public class Utils {

    public static java.sql.Time getHoraAtual() {
        return new java.sql.Time(new Date().getTime());
    }

    public static java.sql.Date getDataAtual() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return strToSQLDate(sdf.format(new Date()));
        } catch (Exception e) {
            return new java.sql.Date(new Date().getTime());
        }
    }

    public static Date strTodate(String data) throws Exception {
        if (data == null || data.length() == 0) {
            return null;
        }
        try {
            SimpleDateFormat date = null;
            if (data.indexOf("-") > -1) {
                date = new SimpleDateFormat("yyyy-MM-dddd");
            } else if (data.length() == 10) {
                date = new SimpleDateFormat("dd/MM/yyyy");
            } else {
                date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            }
            if (data.equals("") || data.length() == 0) {
                return null;
            } else {
                return date.parse(data);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static java.sql.Date strToSQLDate(String data) throws Exception {
        if (data == null || data.length() == 0) {
            return null;
        }
        return new java.sql.Date(strTodate(data).getTime());
    }

    public String gerarMD5(String valor) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
            sen = hash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
        }
        return sen;
    }

    public String gerarSha1(String valor) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
            BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
            sen = hash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
        }
        return sen;
    }

    public static String delCaracterSpecial(String s) {
        String temp = Normalizer.normalize(s, java.text.Normalizer.Form.NFD);
        return temp.replaceAll("[^\\p{ASCII}]", "");
    }
}
