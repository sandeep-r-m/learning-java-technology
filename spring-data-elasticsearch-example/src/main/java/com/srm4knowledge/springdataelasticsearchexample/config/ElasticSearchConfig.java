package com.srm4knowledge.springdataelasticsearchexample.config;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
public class ElasticSearchConfig {

	@Bean
	public ElasticsearchTemplate elasticsearchTemplate(Client client) {
		return new ElasticsearchTemplate(client);
	}

	@Bean
	public Client client(@Value("${elasticsearch.home}") String elasticsearchHome,
			@Value("${elasticsearch.cluster.name}") String clusterName,
			@Value("${elasticsearch.transport.host}") String transportHost,
			@Value("${elasticsearch.transport.port}") int transportPort) {

		System.out.println("====ELASTICSEARCH PROPS========");
		System.out.println("elasticsearchHome = " + elasticsearchHome);
		System.out.println("clusterName = " + clusterName);
		System.out.println("transportHost = " + transportHost);
		System.out.println("transportPort = " + transportPort);
		System.out.println("====ELASTICSEARCH PROPS========");

		Settings settings = Settings.builder().put("client.transport.sniff", true).put("path.home", elasticsearchHome)
				.put("cluster.name", clusterName).put("client.transport.ignore_cluster_name", false).build();

		TransportClient client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new TransportAddress(new InetSocketAddress(transportHost, transportPort)));

		return client;
	}

}
