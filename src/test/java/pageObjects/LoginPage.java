package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginPage {

	public WebDriver ldriver;
	//ArrayList<String> nameListFromAPI = new ArrayList();;
	Map<String,String> nameHSFromAPI = new HashMap<String,String>();
	
	//ArrayList<String> nameListFromUI = new ArrayList();;
	Map<String,String> nameHSFromUI = new HashMap<String,String>();
	
	
	

	//ArrayList<String> descListFromAPI = new ArrayList();;
	//ArrayList<String> descListFromUI = new ArrayList();;

	Response response;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='/orgs/django/repositories' and @class='UnderlineNav-item ']")
	@CacheLookup
	WebElement repoTab;
	
	@FindBy(xpath = "//a[@itemprop='name codeRepository']")
	@CacheLookup
	List<WebElement> repos;
	
	@FindBy(xpath = "//p[@itemprop='description']")
	@CacheLookup
	List<WebElement> reposDesc;
	
	
	//p[@itemprop='description']//path +repos[i]

	public void clickRepo() {
		repoTab.click();
	}

	public void getAllRepoTitleAndDescFromUI() {
		System.out.println("====================getAllRepoTitleFromUI======================");
		List<WebElement> webList = repos;
		List<WebElement> webListDesc = reposDesc;

		Iterator<WebElement> it = webList.iterator();

		while (it.hasNext()) {
			// System.out.println(it.next().getText());
			//nameListFromUI.add(it.next().getText());
			
			//a[@itemprop='name codeRepository' and normalize-space() = 'daphne']//parent::*//parent::*//p[@itemprop='description']
			
			//By.xpath(null).toString();
			
			String t=it.next().getText();
			String d="";
			try {
			 d=ldriver.findElement(By.xpath(
					"//a[@itemprop='name codeRepository' and normalize-space() = '"+t+"']//parent::*//parent::*//p[@itemprop='description']")).getText();
			}
			catch(Exception e) {
				d="null";
			}
			nameHSFromUI.put(t, d);
			
			
		}

		//Collections.sort(nameListFromUI);
		
		System.out.println("*********nameListFromUI*********");
//		nameHSFromUI.put("1", "ak1");
//		nameHSFromUI.put("2", "ak2");
//		nameHSFromUI.put("3", "ak3");

		System.out.println(nameHSFromUI);
		
		
//		Iterator<WebElement> it1 = webListDesc.iterator();
//
//		while (it1.hasNext()) {
//			// System.out.println(it.next().getText());
////			String temp=it1.next().getText();
////			if(!temp.equals(null)) {
//			descListFromUI.add(it1.next().getText());
////			}
//		}
//		
//		
//
//		Collections.sort(descListFromUI);
//		
//		
//		System.out.println("*********descListFromUI*********");
//
//		System.out.println(descListFromUI);

	}

	public void getAllRepoTitleAndDescFromAPI(String url) {
		System.out.println("====================getAllRepoTitleFromAPI======================");

		response = RestAssured.given().when().get(url).then().extract()
				.response();

		// Response response = given().auth().preemptive().basic("test.manager",
		// "test.manager").when().get(API);
		JSONArray JSONResponseBody = new JSONArray(response.body().asString());
		
		//JSONArray JSONResponseBody=response.body().asString();
		// System.out.println((JSONResponseBody.getJSONObject(9).getString("name")));

		int i = 0;

		// nameListFromAPI = new ArrayList();
		//System.out.println("json length ="+JSONResponseBody.length());

		while (i < JSONResponseBody.length()) {
			

//			nameListFromAPI.add((JSONResponseBody.getJSONObject(i).getString("name")));
//			descListFromAPI.add((JSONResponseBody.getJSONObject(i).get("description").toString()));
//			
			
			nameHSFromAPI.put((JSONResponseBody.getJSONObject(i).getString("name")), (JSONResponseBody.getJSONObject(i).get("description").toString()));
			
			i++;
		}

//		for(int j=0;j<nameListFromAPI.size();j++) {
//			System.out.println(nameListFromAPI.get(j));
//		}

		//Collections.sort(nameListFromAPI);
		//Collections.sort(descListFromAPI);
		
		//while(descListFromAPI.remove(null));
		
		//descListFromAPI.removeAll(Collections.singleton("null"));

		//System.out.println(nameListFromAPI);
		
		
//		nameHSFromAPI.put("1", "ak1");
//		nameHSFromAPI.put("3", "ak9");
//		nameHSFromAPI.put("2", "ak2");
		
		System.out.println("api hs === "+nameHSFromAPI);

	}

	public void verifyTitlesAndDescFromUIandAPI() {
//		Assert.assertEquals(nameListFromAPI, nameListFromUI);
//		Assert.assertEquals(descListFromAPI, descListFromUI);
		
//		 Iterator itUI = nameHSFromUI.entrySet().iterator();
//		    while (itUI.hasNext()) {
//		        Map.Entry pair = (Map.Entry)itUI.next();
//		        System.out.println("This is UI hm : "+pair.getKey() + " = " + pair.getValue());
//		        Iterator itAPI = nameHSFromAPI.entrySet().iterator();
//		        while (itAPI.hasNext()) {
//			        Map.Entry pairAPI = (Map.Entry)itAPI.next();
//			        System.out.println("This is API hm : "+pairAPI.getKey() + " = " + pairAPI.getValue());
//			        if(pair.getKey()==pairAPI.getKey() && pair.getValue()==pairAPI.getValue()) {
//			        	System.out.println("good");
//			        	break;
//			        }
//			       
//			    }
//		       
//		    }
		
		System.out.println("Validation");
		
		if(nameHSFromUI.equals(nameHSFromAPI)) {
			System.out.println("passed");
		}
		else {
			System.out.println("failed");
		}
		

	}

}
