package com.mariworld.sample.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.java.Log;

@Log
public class ConnectionTest {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	@Test
	public void testConnection() {
		
		try {Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@dbiair_high?TNS_ADMIN=C:/study-cicd",
				"admin",
				"Thfeptmzm8013"
				);
		log.info("con: " + con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	 

}
