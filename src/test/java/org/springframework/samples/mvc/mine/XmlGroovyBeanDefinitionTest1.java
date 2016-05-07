package org.springframework.samples.mvc.mine;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class XmlGroovyBeanDefinitionTest1 {

	@Test
	public void test() {
		ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:spring-config-xml.groovy");
		MessagePrinter messagePrinter = (MessagePrinter) ctx.getBean("messagePrinter");
		
		messagePrinter.printMessage();
	}
}
