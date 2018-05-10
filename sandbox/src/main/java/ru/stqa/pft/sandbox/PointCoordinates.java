package ru.stqa.pft.sandbox;

public class PointCoordinates {
  public static void main (String[] args) {
          Point p1 = new Point(9, 10);
          Point p2 = new Point(3, 11);
          System.out.println("Расстояние между точками A c координатами (" + p1.x + "; " + p1.y + ") и B с координатами (" + p2.x + "; " + p2.y + ") составляет " +  Math.round(p1.distance(p2)*100.0)/100.0);
       }
}
