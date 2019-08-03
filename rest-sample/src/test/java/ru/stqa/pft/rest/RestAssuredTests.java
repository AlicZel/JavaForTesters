package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase{
    Integer issueId=4179;
    BigInteger bigInteger = BigInteger.valueOf(issueId);

  @Test
  public void testCreateIssue() throws IOException {
      skipIfNotFixed(bigInteger);
      Set<Issue> oldIssues = app.rest().getIssues();
      Issue newIssue =  new Issue().withSubject("TestIssue19").withDescription("NewTestIssue19");
        app.rest().createIssue(newIssue);
//    Set<Issue> newIssues = app.rest().getIssues();
//     oldIssues.add(newIssue.withId(issueId));
      Issue createdIssue =app.rest().getIssue(newIssue.getId()).stream().findFirst().get();

     assertEquals(app.rest().getIssue(newIssue.getId()).stream().findFirst().get(),newIssue);
  }



}
