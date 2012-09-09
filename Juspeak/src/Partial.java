/*
 *  This file is part of Juspeak.
 *
 *  Juspeak is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Juspeak is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Juspeak.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;

/**
 * Partial.java
 * Purpose: Object that contains Points.
 *
 * @author Gabriel Sanchez
 * @version 1.0
 */
public class Partial{
	
	int partial;
	int numberOfPoints;
	double start;
	double end;
	ArrayList<Point> points = new ArrayList<Point>();
	
	/**
	 * Constructor.
	 */
	public Partial(){}
	
	/**
	 * Constructor.
	 * @param partial
	 * @param numberOfPoints
	 * @param start
	 * @param end
	 */
	public Partial(int partial, int numberOfPoints, double start, double end){
		this.partial = partial;
		this.numberOfPoints = numberOfPoints;
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Constructor.
	 * @param partial
	 * @param numberOfPoints
	 * @param start
	 * @param end
	 * @param points
	 */
	public Partial(int partial, int numberOfPoints, double start, double end,
				  ArrayList<Point> points){
		this.partial = partial;
		this.numberOfPoints = numberOfPoints;
		this.start = start;
		this.end = end;
		this.points = points;
	}
	
	/**
	 * Get Partial.
	 * @return partial
	 */
	public int getPartial(){
		return partial;
	}

	/**
	 * Set Partial.
	 * @param partial
	 */
	public void setPartial(int partial){
		this.partial = partial;
	}

	/**
	 * Get Number of Points.
	 * @return numberOfPoints
	 */
	public int getNumberOfPoints(){
		return numberOfPoints;
	}

	/**
	 * Set Number of Points.
	 * @param numberOfPoints
	 */
	public void setNumberOfPoints(int numberOfPoints){
		this.numberOfPoints = numberOfPoints;
	}

	/**
	 * Get Start.
	 * @return start
	 */
	public double getStart(){
		return start;
	}

	/**
	 * Set Start.
	 * @param start
	 */
	public void setStart(double start){
		this.start = start;
	}
	
	/**
	 * Get End.
	 * @return end
	 */
	public double getEnd(){
		return end;
	}
	
	/**
	 * Set End.
	 * @param end
	 */
	public void setEnd(double end){
		this.end = end;
	}
	
	/**
	 * Get Points.
	 * @return points
	 */
	public ArrayList<Point> getPoints(){
		return points;
	}
	
	/**
	 * Set Points.
	 * @param points
	 */
	public void setPoints(ArrayList<Point> points){
		this.points = points;
	}
	
	/**
	 * Add a Point.
	 * @param p
	 */
	public void addPoint(Point p){
		this.points.add(p);
	}	
}