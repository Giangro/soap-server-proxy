package it.poste.sfproxy.ws;

import java.time.Instant;
import java.util.Optional;
import java.util.function.Predicate;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.cxf.annotations.SchemaValidation;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import it.poste.sfproxy.config.ApplicationContextHolder;
import it.poste.sfproxy.ws.eventdelivery.ArrayOfItemEntity;
import it.poste.sfproxy.ws.eventdelivery.ITTEventDelivery;
import it.poste.sfproxy.ws.eventdelivery.ObjectFactory;
import lombok.extern.slf4j.Slf4j;

@WebService(name = "ITTEventDelivery", targetNamespace = "http://it.posteitaliane.gme/")
@XmlSeeAlso({
    ObjectFactory.class
})
@Slf4j
public class ITTEventDeliveryImpl implements ITTEventDelivery {

    @Override
    public void eventDelivery(ArrayOfItemEntity eventEntities) {        
        log.info("eventDelivery " + eventEntities.toString());
    }
    
}
