/**
 * 
 */
package configProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mangesh
 * 
 */
public class Configuration {
	
	private ClassLoader loader = getClass().getClassLoader();
	private File file = new File(loader.getResource("configuration/configuration.properties").getFile());
	static Properties config;
	public static Configuration configuration;

	private Configuration() throws IOException {
		config = new Properties();
		config.load(new FileInputStream(file));
	}

	public static String getConfig(String key) throws IOException {
		if (configuration == null) {
			configuration = new Configuration();
			return config.getProperty(key);
		} else {
			return config.getProperty(key);
		}
	}
}
