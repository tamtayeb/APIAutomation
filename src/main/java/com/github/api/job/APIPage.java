package com.github.api.job;

import java.util.Scanner;

import com.jayway.restassured.RestAssured;

public class APIPage {
	protected static Scanner scanner = new Scanner(System.in);
	protected String agreed;
	protected String url = "https://jobs.github.com/positions.json";

	public void requestURL() {
		System.out.println("Enter yesif you want to search for a specific Job");
		agreed = scanner.next();
		if (agreed.equals("yes")) {
			RestAssured.get(createURL());
		} else {
			RestAssured.get(url);
		}
	}

	public boolean welcomeUser() {
		System.out.println("Enter yes if you want to search for a job using it's Location");
		String desicion = scanner.next();
		if (desicion.equals("yes")) {
			return true;
		} else {
			return false;
		}

	}

	public String createURL() {
		if (welcomeUser()) {
			url = url + "?search=" + getDescrptionParam() + "&location=" + getLocationParam() + "&full_time="
					+ getTimeParam() + "&page=" + getPageParam();
		} else {
			url = url + "?search=" + getDescrptionParam() + "&lat=" + getLatParam() + "&long=" + getLongParam()
					+ "&full_time=" + getTimeParam() + "&page=" + getPageParam();
		}
		return url;
	}

	public String getLocationParam() {
		String location = "";
		System.out.println("Enter Job location");
		location = scanner.next();
		return location;
	}

	public String getDescrptionParam() {
		String description = "";
		System.out.println("Enter yes if you want to Specify Job Description for exapmle python");
		agreed = scanner.next();
		if (agreed.equals("yes")) {
			System.out.println("Enter Job Description");
			description = scanner.next();
		} else {

		}
		return description;
	}

	public String getPageParam() {
		String page = "";
		System.out
				.println("Enter yes if you want to Specify Results Page, you will be able to view 50 results at once");
		agreed = scanner.next();
		if (agreed.equals("yes")) {
			System.out.println("Enter Page");
			page = scanner.next();
		} else {

		}
		return page;

	}

	public boolean getTimeParam() {
		System.out.println("Enter yes if you want to search for Full time Job");
		agreed = scanner.next();
		if (agreed.equals("yes")) {
			return true;
		} else {
			return false;
		}

	}

	public String getLongParam() {
		String longitude = "";

		System.out.println("Enter yes if you want to Specify Job latitude and longitude");
		agreed = scanner.next();
		if (agreed.equals("yes")) {
			System.out.println("Enter longitude");
			longitude = scanner.next();
		} else {

		}
		return longitude;
	}

	public String getLatParam() {
		String latitude = "";

		System.out.println("Enter latitude value");
		latitude = scanner.next();
		return latitude;

	}

}
