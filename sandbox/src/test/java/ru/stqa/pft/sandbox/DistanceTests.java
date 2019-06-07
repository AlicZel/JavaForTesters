package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.*;

public class DistanceTests {


  @Test
  public void testDistancePlusCoo() {
    Point p1 = new Point(345.0, 7678.0);
    Point p2 = new Point(1.0, 899.0);

    Assert.assertEquals(p2.distance(p1), 6787.722519372754);

  }

  @Test
  public void testDistanceOneMinusCoo() {
    Point p1 = new Point(0.0, 0.0);
    Point p2 = new Point(-1.0, 899.0);

    Assert.assertEquals(p2.distance(p1), 899.0005561733541);

  }

  @Test
  public void testDistanceAllMinusCoo() {
    Point p1 = new Point(-600.0, 0.0);
    Point p2 = new Point(-1.0, -899.0);

    Assert.assertEquals(p2.distance(p1), 1080.2786677519834);

  }

  @Test
  public void testDistanceTheSamePoint() {
    Point p1 = new Point(1.0, 1.0);
    Point p2 = new Point(1.0, 1.0);

    Assert.assertEquals(p2.distance(p1), 0);

  }
}
