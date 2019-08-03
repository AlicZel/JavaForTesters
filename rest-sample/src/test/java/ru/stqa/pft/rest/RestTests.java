package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;



public class RestTests {


  @Test
  public void testCreateIssue() throws IOException {
    //  Set<Issue> oldIssues = getIssues();
    //  Issue newIssue =  new Issue().withSubject("Test issue 2").withDescription("new test issue 2");
    //  Integer issueId=
    createIssue();
    Set<Issue> newIssues = getIssues();
    // oldIssues.add(newIssue.withId(issueId));
    // assertEquals(newIssues,oldIssues);
  }

  private Executor createIssue() throws IOException {
    // String json=getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json")
    Executor executor =getExecutor();
            //.execute(Request.Post("http://demo.bugify.com/api/issues.json"));
    return executor;
    //   .bodyForm(new BasicNameValuePair("subject",newIssue.getSubject()),
    //        new BasicNameValuePair("description",newIssue.getDescription()) ))
    //        .returnContent().asString();
    //  JsonElement parsed = new JsonParser().parse(json);
    //   return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

  private Set<Issue> getIssues() throws IOException {
    String json=getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
            .returnContent().asString();
    JsonParser jsonParser =new JsonParser();
    JsonElement parsed= jsonParser.parse(json);
    JsonElement issues =parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());
  }



    public Executor getExecutor() {
      return Executor.newInstance()
              .auth("f060103b7877858acb33f95ace052441","");
    }


}
