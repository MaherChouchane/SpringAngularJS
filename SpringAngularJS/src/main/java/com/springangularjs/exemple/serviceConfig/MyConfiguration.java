package com.springangularjs.exemple.serviceConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyConfiguration {

	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private ApplicationContext context;

	ObjectMapper mapper = new ObjectMapper();

	public List<HashMap<?, ?>> injectUsingResourceLoader(String path) throws IOException {
		Resource resource = resourceLoader.getResource(path);

		InputStream data = resource.getInputStream();
		List<HashMap<?, ?>> json = mapper.readValue(data, List.class);
		return json;
	}

	public ArrayList<HashMap<?, ?>> injectUsingApplicationContext(String path) throws IOException {

		Resource resource = context.getResource(path);
		InputStream data = resource.getInputStream();
		ArrayList<HashMap<?, ?>> json = mapper.readValue(data, ArrayList.class);
		return json;
	}
}
