package org.springframework.samples.mvc.mine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericGroovyXmlContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config-xml.groovy", loader = 
	GenericGroovyXmlContextLoader.class)
public class XmlGroovyBeanDefinitionTest2 {
	
	@Autowired
	private MessagePrinter messagePrinter;
	
	@Test
	public void test() {
		messagePrinter.printMessage();
	}

}
