package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(Double x, Double y){
    this.x=x;
    this.y=y;
  }

  public double distance(Point p1){
    return Math.sqrt((this.x-p1.x)*(this.x-p1.x) +(this.y-p1.y)*(this.y-p1.y));
  }

}
