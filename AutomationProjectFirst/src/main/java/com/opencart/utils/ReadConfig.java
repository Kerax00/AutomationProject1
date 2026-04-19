package com.opencart.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public Properties prop1;

	public ReadConfig() throws Exception {

		// Creating a Input Stream to fetch the data from config file.
		FileInputStream input1 = new FileInputStream(".\\src\\test\\resources\\config.properties");
		prop1 = new Properties();
		prop1
				.load(input1);
	}

	/**
	 * public static void main(String[] args) throws Exception { ReadConfig my = new
	 * ReadConfig(); System.out .println(my.prop1 .getProperty("browser")); }
	 **/

}
