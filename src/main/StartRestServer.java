import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StartRestServer {

public static void main(String[] args) {
	HttpServer server = null;
	try {
		server = HttpServerFactory.create( "http://localhost:8081/api/" );
	} catch (IOException e) {
		e.printStackTrace();
	}

	server.start();
	Properties p = new Properties();
	try {
		p.load(new BufferedInputStream(new FileInputStream("java.properties")));
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println(p.getProperty("mySqlPath"));
	JOptionPane.showMessageDialog( null, "Ende" );

	server.stop( 0 );
	}

}
