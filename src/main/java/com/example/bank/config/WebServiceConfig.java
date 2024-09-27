package com.example.bank.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        var servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "transactions")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        var wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TransactionPort");
        wsdl11Definition.setLocationUri("/ws/trans");
        wsdl11Definition.setTargetNamespace("https://bank/transactions");
        wsdl11Definition.setSchema(schema);

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema transactionsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("transactions.xsd"));
    }
}
