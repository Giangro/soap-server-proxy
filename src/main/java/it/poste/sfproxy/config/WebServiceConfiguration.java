package it.poste.sfproxy.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.poste.sfproxy.ws.ITTEventDeliveryImpl;
import it.poste.sfproxy.ws.ITTPostalObjectAcceptanceImpl;

@Configuration
public class WebServiceConfiguration {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint postalObjectAcceptanceEndpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new ITTPostalObjectAcceptanceImpl());
		endpoint.publish("/TTService/PostalObjectAcceptance");
		return endpoint;
	}

	@Bean
	public Endpoint eventDeliveryEndpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new ITTEventDeliveryImpl());
		endpoint.publish("/TTService/EventDelivery");
		return endpoint;
	}

}
