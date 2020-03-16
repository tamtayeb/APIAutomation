package com.github.api.test;

import org.apache.http.protocol.RequestUserAgent;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.api.job.APIPage;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class APITest {
	Response response ;

	APIPage page = new APIPage();

	@Test
	public void CheckAPI() {

		page.requestURL();
	}

}