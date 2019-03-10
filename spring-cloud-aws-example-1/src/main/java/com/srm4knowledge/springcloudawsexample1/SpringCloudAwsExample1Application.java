package com.srm4knowledge.springcloudawsexample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudAwsExample1Application implements CommandLineRunner {

	@Autowired
	private SpringCloudAWSUtils awsUtils;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAwsExample1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String s3ObjUrl = "";

		awsUtils.downloadS3Object(s3ObjUrl);
	}

}
