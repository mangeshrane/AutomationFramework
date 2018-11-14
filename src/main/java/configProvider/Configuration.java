/**
 * 
 */
package configProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import testBase.DriverFactory;

/**
 * @author Mangesh
 * 
 */
public class Configuration {
	
	static Logger log = Logger.getLogger("AutomationFramework");
	private ClassLoader loader = getClass().getClassLoader();
	private File file;
	static Properties config;
	public static Configuration configuration;

	private Configuration() throws IOException {
		if(System.getenv("CONFIG_FILE") != null) {
			log.info("Found CONFIG_FILE env using config file from path");
			file = new File(loader.getResource("configuration/" + System.getenv("CONFIG_FILE")).getFile());
		}else {
			file = new File(loader.getResource("configuration/configuration.properties").getFile());
			log.info("Loaded configuration.properties file");
		}
		config = new Properties();
		config.load(new FileInputStream(file));
	}

	public static String getConfig(String key) {
		String value = null;
		try {
		if (configuration == null) {
				configuration = new Configuration();
				value = config.getProperty(key);
				log.info("Returning value for " + key + " Value: " + value);
		} else {
			value =  config.getProperty(key);
			log.info("Returning value for " + key + " Value: " + value);
		}
		} catch (IOException e) {
			log.error("Error in Loading Config File /Getting property from properties File");
			e.printStackTrace();
		}
		return value;
	}
}
