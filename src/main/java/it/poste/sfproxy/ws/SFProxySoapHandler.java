package it.poste.sfproxy.ws;

import lombok.extern.slf4j.Slf4j;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.HashSet;
import java.util.Set;
import javax.xml.ws.handler.MessageContext;

@Slf4j
public class SFProxySoapHandler implements SOAPHandler<SOAPMessageContext> {	

    @Override
    public Set<QName> getHeaders() {                
        final Set<QName> headers = new HashSet<>();
        
        final QName h1 = new QName(
            "http://schemas.microsoft.com/ws/2005/05/addressing/none"
        ,"To");             
        
        final QName h2 = new QName(
            "http://schemas.microsoft.com/ws/2005/05/addressing/none"
        ,"Action");             

        
        headers.add(h1);
        headers.add(h2);
        
        // notify the runtime that this is handled
        return headers;        
        
        
        
    }    

    @Override
    public boolean handleMessage(SOAPMessageContext c) {        
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext c) {        
        return true;
    }

    @Override
    public void close(MessageContext mc) {        
    }
}
