package ru.stqa.pft.rest.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import ru.stqa.pft.rest.model.Issue;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Set;

public class RestHelper {
  private ApplicationManager app;

  public RestHelper(ApplicationManager app) {
    this.app = app;
  }


  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json?limit=1000"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());

  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  public Boolean getStatus(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues/" + BigInteger.valueOf(issueId) + ".json")).returnContent().asString();
    String status = new JsonParser().parse(json).getAsJsonObject().get("issues").getAsJsonArray().get(0).getAsJsonObject().get("state_name").getAsString();
    if (status.equals("Закрыт")) {
      return true;
    }
    return false;
  }

  public int createIssue(Issue newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post("http://bugify.stqa.ru/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}