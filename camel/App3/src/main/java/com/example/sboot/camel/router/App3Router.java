package com.example.sboot.camel.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class App3Router extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		from("timer:simpleTimer?period=10s&repeatCount=10")
		.to("direct:get-product")
        .to("direct:post-product");
		
		 from("direct:get-product")
         .setHeader(Exchange.HTTP_METHOD).constant(HttpMethod.GET)
         .to("http://localhost:8070/app1/getProductInfo");

		 from("direct:post-product")
		 .setHeader(Exchange.HTTP_METHOD).constant(HttpMethod.POST)
		 .to("http://localhost:8090/app2/postProductInfo?body=$body");
			
	}


}
