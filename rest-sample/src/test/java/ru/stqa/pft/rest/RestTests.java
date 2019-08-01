package ru.stqa.pft.rest;

import java.io.IOException;
import java.util.Set;

import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;
import static org.testng.Assert.assertEquals;

public class RestTests {

  @Test
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue =  new Issue();
    Integer issueId= createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues,oldIssues);
  }

  private Integer createIssue(Issue newIssue) {
    return null;
  }

  private Set<Issue> getIssues() throws IOException {
    String json=getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
            .returnContent().asString();
    return null;
  }

  public Executor getExecutor() {
    return Executor.newInstance()
            .auth("28accbe43ea112d9feb328d2c00b3eed","");
  }


}
