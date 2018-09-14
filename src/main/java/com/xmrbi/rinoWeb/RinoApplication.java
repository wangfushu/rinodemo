package com.xmrbi.rinoWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RinoApplication  implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(RinoApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(RinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8989;
		}
		new DiscardServer(port).run();
		System.out.println("server:run()");
	}
}
