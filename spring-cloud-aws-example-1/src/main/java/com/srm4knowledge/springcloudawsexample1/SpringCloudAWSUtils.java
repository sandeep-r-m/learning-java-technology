package com.srm4knowledge.springcloudawsexample1;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class SpringCloudAWSUtils {

	@Autowired
	private ResourceLoader resourceLoader;

	public SpringCloudAWSUtils() {
		// TODO Auto-generated constructor stub
	}

	public void downloadS3Object(String s3url) throws Exception {
		Resource resource = resourceLoader.getResource(s3url);
		File file = new File(resource.getFilename());

		try (InputStream is = resource.getInputStream()) {
			Files.copy(is, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

}
