package it.poste.sfproxy.ws;

import java.time.Instant;
import java.util.Date;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.annotations.SchemaValidation;

import it.poste.sfproxy.config.ApplicationContextHolder;
import it.poste.sfproxy.ws.accettazione.ArrayOfPostalObjectAcceptanceEntity;
import it.poste.sfproxy.ws.accettazione.ITTPostalObjectAcceptance;
import it.poste.sfproxy.ws.accettazione.ObjectFactory;
import it.poste.sfproxy.ws.accettazione.PostalObjectAcceptanceEntity;

@Slf4j
@WebService(name = "ITTPostalObjectAcceptance", targetNamespace = "http://it.posteitaliane.gme/")
@XmlSeeAlso({
    ObjectFactory.class
})
@HandlerChain(file = "/handlers.xml")
public class ITTPostalObjectAcceptanceImpl implements ITTPostalObjectAcceptance {

    @Override
    public void postalObjectAcceptance(ArrayOfPostalObjectAcceptanceEntity postalObjectAcceptanceEntities) {
        postalObjectAcceptanceEntities.getPostalObjectAcceptanceEntity().forEach(poe->log.info(poe.toString()));
        //log.info("postalObjectAcceptance " + postalObjectAcceptanceEntities.getPostalObjectAcceptanceEntity().toString());
    }

}
