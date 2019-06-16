package ru.stqa.pft.sandbox;

public class Equality {
  public static void main (String[] args){
    String s1="firefox";
    //String s2="firefox"; kompilator optymalizuje kod i mysli ze  to ten sam obiekt (adres)
   // String s1=s2; ten sam link
    String s2= new String(s1); //to nowy link do adresu

    System.out.println(s1==s2); //porównanie linków
    System.out.println(s1.equals(s2)); // porównuje zawartość linków, dlatego jest ona poprawna
  }

// typy proste nie są obiektami wiec można je porównywać za pomocą znaku ==
}
