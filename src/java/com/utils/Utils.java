package com.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jsturla
 */
@ManagedBean(name = "utils")
@ApplicationScoped
public class Utils {

    public static String createPasswdHash(String passwd) {
        MessageDigest md;
        String rval = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(passwd.getBytes(), 0, passwd.length());

            rval = new BigInteger(1, md.digest()).toString(16).toUpperCase();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rval.length() > 20 ? rval.substring(0, 20) : rval;
    }

}
