package ru.stqa.pft.rest.tests;

import com.google.protobuf.ServiceException;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {
  @Test
  public void createIssue() throws IOException, ServiceException {
    skipIfNotFixed(1);
    Set<Issue> oldIssues = app.rest().getIssues();
    Issue newIssue = new Issue().withSubject("Test Anna issue").withDescription("New test issue");
    int issueId = app.rest().createIssue(newIssue);
    Set<Issue> newIssues = app.rest().getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }


}