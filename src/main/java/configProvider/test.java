package configProvider;

import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String c = Configuration.getConfig("key");
		System.out.println(c);
	}

}
