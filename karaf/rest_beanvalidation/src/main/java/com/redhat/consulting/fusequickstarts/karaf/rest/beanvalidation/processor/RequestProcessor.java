package com.redhat.consulting.fusequickstarts.karaf.rest.beanvalidation.processor;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

public class RequestProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        exchange.setPattern(ExchangePattern.InOut);
        Message inMessage = exchange.getIn();
        // set the operation name
        inMessage.setHeader(CxfConstants.OPERATION_NAME, "getSampleUser");
        // using the proxy client API
        inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);
        // creating the request
        MessageContentsList req = new MessageContentsList();
        // setting id which start with one (i.e. pattern: regexp = "^1[0-9]*$")
        req.add("1");
        inMessage.setBody(req);

    }

}
