package ru.stqa.pft.addressbook.tests;

import java.util.Comparator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModificationFromList(){
    if (!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().clickEditFromList(before.size()-1);
    app.getContactHelper().fillContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", null,
            "Piekna 2\nEłk", "508456456", "uwaga"),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
    List<ContactData> after=app.getContactHelper().getContactList();
    Comparator<? super ContactData> byId=(g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);


  }

  @Test
  public void testContactModificationFromDetails() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();}
       List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().goToContactDetails(before.size()-1);
      app.getContactHelper().clickModifyButton();
      app.getContactHelper().fillContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", null,
              "Piekna 2\nEłk", "508456456", "uwaga"), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().goToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
    Comparator<? super ContactData> byId=(g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);

// Gdy porównujemy zbiory (Set) musimy zadbac o unikalnośc elementów, dlatego wcześniej posługiwaliśmy się dodatkowo id
  // Gdy porównujemy list to można je posortowac i nie zbać o unikalność (po modyfikacji nie wiadomo gdzie element
    // znajdzie się na liście , bo nie dokońca wiadomo jakie sortowanie jest zastosowane w aplikacji

  }}

