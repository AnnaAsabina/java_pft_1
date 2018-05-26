package ru.stqa.pft.sandbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"java", "С#", "Python", "PHP"};

    List<String> languages = new ArrayList<String>();
    languages.add("java");
    languages.add("С#");
    languages.add("Python");
    languages.add("PHP");


    List<String> languagess = Arrays.asList("java", "С#", "Python", "PHP");
    languages.add("java");
    languages.add("С#");
    languages.add("Python");
    languages.add("PHP");

    for (String l : languages) {
      System.out.println("я хочу выучить " + l);
    }
  }
}