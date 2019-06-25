package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {

    String[] langs = {"Java", "C#", "Python", "PHP"}; //tablica
    //lub
    // String[] langs = new String[4];
    //langs[0]="Java";
    //langs[1]="C#";
    //langs[2]="Python";
    //langs[3]="PHP";

    for (int i = 0; i < langs.length; i++) { //lenght oraz nawiasy [] dotyczą tablic
      System.out.println("I want to learn " + langs[i]);
    }
//tozsamy zapis
    for (String l : langs) {
      System.out.println("I want to learn " + l);
    }

    //List<String> languages = new ArrayList<String>();//ArrayList to jedna z klas implementujących Listę
    List<String> languages = Arrays.asList("Java","C#","Python","PHP");
    //nie piszemy ArrayList<String> ccc= new ArrayList<String>; ponieważ możemy pod zmienna podstawiac inne klasy
    // które implementują interfajs List
    for(int i=0;i<languages.size();i++){ //size oraz get dotyczy listy
      System.out.println("I want to learn "+languages.get(i));
    }

  }


}
