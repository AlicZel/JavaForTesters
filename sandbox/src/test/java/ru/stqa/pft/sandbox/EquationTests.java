package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.*;


public class EquationTests {
@Test
  public void test0(){
    Equation1 e = new Equation1(1,1,1);
  Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void test1(){
    Equation1 e = new Equation1(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
  }
@Test
  public void test2(){
    Equation1 e = new Equation1(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);
  }

  @Test
  public void test3(){
    Equation1 e = new Equation1(0,1,1);
    Assert.assertEquals(e.rootNumber(),1);
  }


  @Test
  public void test4(){
    Equation1 e = new Equation1(0,0,1);
    Assert.assertEquals(e.rootNumber(),0);
  }
  @Test
  public void test5(){
    Equation1 e = new Equation1(0,0,0);
    Assert.assertEquals(e.rootNumber(),-1);
  }
}
