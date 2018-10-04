/**
 * 
 */
package configProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import testBase.BaseClass;

/**
 * @author Mangesh
 * 
 */
public class Configuration extends BaseClass{
	
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
		if (configuration == null) {
			try {
				configuration = new Configuration();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return config.getProperty(key);
		} else {
			return config.getProperty(key);
		}
	}
}
