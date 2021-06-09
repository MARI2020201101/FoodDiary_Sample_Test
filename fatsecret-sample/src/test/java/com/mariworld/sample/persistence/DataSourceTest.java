package com.mariworld.sample.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	@Qualifier("dataSource")
	private DataSource datasource;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void dsConnectionTest() throws SQLException {

		try {
			Connection con = datasource.getConnection();
			log.info("\nconnection : " + con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	
	  @Test public void mybatisTest() throws SQLException {
	  
	  
	  try{ SqlSession session =sqlSessionFactory.openSession(); Connection con =
	  datasource.getConnection(); log.info("\n connection : "+con);
	  log.info("\n SqlSession : "+session);
	  
	  }catch(Exception e) { fail(e.getMessage());
	  
	  } }
	 

}
