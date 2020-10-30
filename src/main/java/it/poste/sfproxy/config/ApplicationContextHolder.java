package it.poste.sfproxy.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		saveApplicationContext(applicationContext); // To make Sonar happy.
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	private static void saveApplicationContext(ApplicationContext applicationContext) {
		ApplicationContextHolder.applicationContext = applicationContext;
	}
}
