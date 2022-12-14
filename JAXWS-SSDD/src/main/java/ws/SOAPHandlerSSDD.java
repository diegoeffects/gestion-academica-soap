package ws;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;

public class SOAPHandlerSSDD implements SOAPHandler<SOAPMessageContext> {
    Logger logger;

    public SOAPHandlerSSDD() {
        super();
        logger = Logger.getLogger(SOAPHandlerSSDD.class);
    }

    @Override
    public void close(MessageContext arg0) {

    }

    @Override
    public boolean handleFault(SOAPMessageContext arg0) {
        return false;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {
     
        Boolean outboundProperty = (Boolean) smc
                .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            logger.debug("\nOutbound message:");
              //this is underlying http response object
              HttpServletResponse response = (HttpServletResponse) smc.get(MessageContext.SERVLET_RESPONSE);

                response.addHeader("Access-Control-Allow-Origin", "*");
                response.addHeader("Access-Control-Allow-Credentials", "false");
                response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, x-requested-with, Content-Type, SOAPAction, Access-Control-Allow-Headers, Access-Control-Response-Headers, Access-Control-Allow-Methods, Access-Control-Allow-Origin");
        } else {
            logger.debug("\nInbound message:");
        }

        return true;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}