/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.util;

import java.io.File;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrator
 */
public class Log4jUtil {

    public static boolean loadLog4jProperties() throws Exception {
	try {
	    String prefix = ".." + File.separator;
	    String log4jPath = prefix + "log4j.properties";
	    PropertyConfigurator.configure(log4jPath);
	    return true;
	} catch (Exception ex) {
	    throw new Exception("ERROR: fail to load log4j.properties.", ex);
	}
    }
}
