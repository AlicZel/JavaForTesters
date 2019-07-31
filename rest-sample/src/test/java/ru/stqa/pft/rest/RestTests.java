package ru.stqa.pft.rest;

import java.util.Set;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class RestTests {

  @Test
  public void testCreateIssue(){
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

  private Set<Issue> getIssues() {
    Request.Get(" http://demo.bugify.com/api//issues.json")
  }
}
