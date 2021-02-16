package org.eclipse.tp.model;

/**
 * @author IB
 *
 */
public class Point {
private double abs;
private double ord;

public Point(double abs, double ord) {
	this.abs = abs;
	this.ord = ord;
}

public double getAbs() {
	return abs;
}

public void setAbs(double abs) {
	this.abs = abs;
}

public double getOrd() {
	return ord;
}

public void setOrd(double ord) {
	this.ord = ord;
}

public double calculerDistance(Point p)
{
	return Math.sqrt(Math.pow(this.abs-p.getAbs(),2)+Math.pow(this.ord-p.getOrd(),2));
}
public Point calculerMilieu(Point p)
{
	return new Point((this.abs+p.getAbs())/2,(this.ord+p.getOrd())/2);
	//return m;
}

@Override
public String toString() {
	return "Point[" + abs + "," + ord + "]";
}

}
