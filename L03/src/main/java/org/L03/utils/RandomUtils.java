package org.L03.utils;

import org.L03.beans.NumberBean;

public class RandomUtils {
  public static NumberBean randomNum(String rangeString) {
    double range;
    try {
      range = Double.parseDouble(rangeString);
    } catch(Exception e) {
      range = 10.0;
    }
    return(new NumberBean(Math.random() * range));
  }
  
  private RandomUtils() {} // Uninstantiable class
}
