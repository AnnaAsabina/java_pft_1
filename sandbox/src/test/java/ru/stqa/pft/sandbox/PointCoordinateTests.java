package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointCoordinateTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(9, 10);
    Point p2 = new Point(3, 11);
    Assert.assertEquals(p1.distance(p2), 6.082762530298219);
  }
}