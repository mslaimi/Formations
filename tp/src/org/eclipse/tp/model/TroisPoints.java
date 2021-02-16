package org.eclipse.tp.model;

/**
 * @author IB
 *
 */
public class TroisPoints {
private Point premier;
private Point deuxieme;
private Point troisieme;
public TroisPoints(Point premier, Point deuxieme, Point troisieme) {
	this.premier = premier;
	this.deuxieme = deuxieme;
	this.troisieme = troisieme;
}
public Point getPremier() {
	return premier;
}
public void setPremier(Point premier) {
	this.premier = premier;
}
public Point getDeuxieme() {
	return deuxieme;
}
public void setDeuxieme(Point deuxieme) {
	this.deuxieme = deuxieme;
}
public Point getTroisieme() {
	return troisieme;
}
public void setTroisieme(Point troisieme) {
	this.troisieme = troisieme;
}
public boolean testerAlignement()
{
	double ab=premier.calculerDistance(deuxieme);
	double ac=premier.calculerDistance(troisieme);
	double bc=deuxieme.calculerDistance(troisieme);
	if ((ab==ac+bc) || (ac==ab+bc) || (bc==ac+ab))
		return true;
	return false;
}
public boolean estTriangleEquilateral()
{
	double ab=premier.calculerDistance(deuxieme);
	double ac=premier.calculerDistance(troisieme);
	double bc=deuxieme.calculerDistance(troisieme);
	if ((ab==ac)&&(ab==bc))
		return true;
	return false;
}
}
