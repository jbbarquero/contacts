package com.malsolo.contacts.domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jbeneito
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext-empty-test.xml")
public class MockTest {

	@Rule
    public TestName name = new TestName();

	@Before
	public void antes() {
		System.err.println(name.getMethodName());
	}

	@Test
	public void testMarkerMethod() {
		System.err.println("? " + name.getMethodName());
	}
	
}
