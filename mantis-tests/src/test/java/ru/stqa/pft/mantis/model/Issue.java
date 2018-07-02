package ru.stqa.pft.mantis.model;

public class Issue {
  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  private int id;
  private String summary;
  private String description;
  private Project project;

  public String getSummary() {
    return summary;
  }



  public String getDescription() {
    return description;
  }



  public Project getProject() {
    return project;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }
  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }
  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }
}
