package utillities;

import org.apache.log4j.Logger;

import testBase.BaseClass;

public class test extends BaseClass{

	public static Logger log = Logger.getLogger(BaseClass.class.getName());
	public static void main(String[] args) {
		CsvReader r =  new CsvReader("/home/mrane/Downloads/test.csv", ",");
		System.out.println(r.getCsvData());
		log.info("test");
		log.warn("warning");
	}

}
