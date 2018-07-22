package com.shl.onetest.base;

import com.shl.onetest.OnetestApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OnetestApplication.class)
public abstract class AbstractSpringTestBase {
	
	public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
	
	@Autowired
	protected ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
	}
}
