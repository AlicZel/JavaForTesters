package ru.stqa.pft.sandbox;

public class TwoPointsDistanceProgram {

  public static void main (String[] args){

    Point p1 = new Point(1.0,1.0);
    Point p2 = new Point(2.0,3.0);

    System.out.println("Distance between P1 = (" + p1.x +", "+p1.y+") and P2 = (" + p2.x +", "+p2.y+")+ is equal "+ distance(p1,p2));

    System.out.println("Distance between P1 = (" + p1.x +", "+p1.y+") and P2 = (" + p2.x +", "+p2.y+")+ is equal "+ p2.distance(p1));


  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) +(p2.y-p1.y)*(p2.y-p1.y));
  }

}
