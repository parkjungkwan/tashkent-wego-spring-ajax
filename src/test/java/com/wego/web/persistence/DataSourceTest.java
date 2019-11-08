package com.wego.web.persistence;

import static org.junit.Assert.fail;
import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wego.web.ctx.RootContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.wego.web.ctx.RootContext.class})
@Log4j
public class DataSourceTest {
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			System.out.println("성공");
			log.info(con);
		}catch(Exception e) {
			System.out.println("실패");
			fail(e.getMessage());
		}
	}
}
