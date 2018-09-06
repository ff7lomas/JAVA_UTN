package com.utils;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@ManagedBean(name = "utils")
@ApplicationScoped
public class Utils {

    
//  private static final org.apache.logging.log4j.Logger logger
//          = org.apache.logging.log4j.LogManager.
//          getLogger("Utils");

  /**
   * Returns a pseudo-random number between min and max, inclusive. The
   * difference between min and max can be at most
   * <code>Integer.MAX_VALUE - 1</code>.
   *
   * @param min Minimum value
   * @param max Maximum value. Must be greater than min.
   * @return Integer between min and max, inclusive.
   * @see java.util.Random#nextInt(int)
   */
  public static int randInt(int min, int max) {

    Random rand = new Random();

    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }

  public static String createPasswdHash(String passwd) {
    MessageDigest md;
    String rval = null;
    try {
      md = MessageDigest.getInstance("MD5");
      md.update(passwd.getBytes(), 0, passwd.length());

      // Lo paso a mayúsc porque el evento de js del lector lo pasa a mayúsc
      rval = new BigInteger(1, md.digest()).toString(16).toUpperCase();
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Lo limito a 30 porque es la cantidad de chars máxima admitida por el campo del DM
    return rval.length() > 20 ? rval.substring(0, 20) : rval;
  }

  

}
