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
		//numberOfPoints++;
	}
	
	/**
	 * Remove a Point
	 */
	public void removePoint(){
	// IMPLEMENT
		numberOfPoints--;
	}
	
	
	/**
	 * Gets the average of the frequencies in the Partial
	 * @return average
	 */
	public double getAverageFrequency(){
		double average = 0;

		if(numberOfPoints<=0)
			return 0;
		
		for(int i = 0; i < numberOfPoints; i++)
			average += this.points.get(i).getFrequency();
		
		average = average/numberOfPoints;
		
		return average;
	}
	
	/**
	 * Gets the average of the amplitudes in the Partial
	 * @return average
	 */
	public double getAverageAmplitude(){
		double average = 0;

		if(numberOfPoints<=0)
			return 0;
		
		for(int i = 0; i < numberOfPoints; i++)
			average += this.points.get(i).getAmplitude();
		
		average = average/numberOfPoints;
		
		return average;
	}
	
	
	/**
	 * Gets the Max Frequency Value
	 * @return Max
	 */
	public double getMaxFrequency(){
		
		double Max = 0;
		
		for(int i = 0; i < numberOfPoints; i++){
			if(this.points.get(i).getFrequency() > Max)
				Max = this.points.get(i).getFrequency();
		}
		
		return Max;
	}
	
	/**
	 * Gets the Point with the Max Frequency Value
	 * @return point
	 */
	public Point getPointWithMaxFrequency(){
		
		double Max = 0;
		int index = 0;
		
		for(int i = 0; i < numberOfPoints; i++){
			if(this.points.get(i).getFrequency() > Max){
				Max = this.points.get(i).getFrequency();
				index = i;
			}
		}
		
		return this.points.get(index);
	}
	
	/**
	 * Gets the Max Amplitude Value
	 * @return Max
	 */
	public double getMaxAmplitude(){
		
		double Max = 0;
		
		for(int i = 0; i < numberOfPoints; i++){
			if(this.points.get(i).getAmplitude() > Max)
				Max = this.points.get(i).getAmplitude();
		}
		
		return Max;
	}
	
	/**
	 * Gets the Point with the Max Amplitude Value
	 * @return point
	 */
	public Point getPointWithMaxAmplitude(){
		
		double Max = 0;
		int index = 0;
		
		for(int i = 0; i < numberOfPoints; i++){
			if(this.points.get(i).getAmplitude() > Max){
				Max = this.points.get(i).getAmplitude();
				index = i;
			}
		}
		
		return this.points.get(index);
	}
	
	/**
	 * Gets the Minimum Frequency Value
	 * @return Min
	 */
	public double getMinFrequency(){
		
		double Min = this.points.get(0).getFrequency();
		
		for(int i = 1; i < numberOfPoints; i++){
			if(this.points.get(i).getFrequency() < Min)
				Min = this.points.get(i).getFrequency();
		}
		
		return Min;
	}
	
	/**
	 * Gets the Point with the Min Frequency Value
	 * @return point
	 */
	public Point getPointWithMinFrequency(){
		
		double Min = this.points.get(0).getFrequency();
		int index = 0;
		
		for(int i = 1; i < numberOfPoints; i++){
			if(this.points.get(i).getFrequency() < Min){
				Min = this.points.get(i).getFrequency();
				index = i;
			}
		}
		
		return this.points.get(index);
	}
	
	/**
	 * Get an Array of the Frequencies in the Partial
	 * @return frequencies
	 */
	public double[] getFrequencies(){
		double[] frequencies = new double[numberOfPoints];
		
		for(int i = 0; i < numberOfPoints; i++){
			frequencies[i] = this.points.get(i).getFrequency();
		}
		
		return frequencies;
	}
	
	/**
	 * Get an Array of the Amplitudes in the Partial
	 * @return amplitudes
	 */
	public double[] getAmplitudes(){
		
		double[] amplitudes = new double[numberOfPoints];
		
		for(int i = 0; i < numberOfPoints; i++){
			amplitudes[i] = this.points.get(i).getAmplitude();
		}
		
		return amplitudes;
	}
	
	/**
	 * Get an Array of the Times in the Partial
	 * @return times
	 */
	public double[] getTimes(){
		
		double[] times = new double[numberOfPoints];
		
		for(int i = 0; i < numberOfPoints; i++){
			times[i] = this.points.get(i).getTime();
		}
		
		return times;
	}
	
	/**
	 * Set new Frequencies to the current Partial.
	 * @param frequencies
	 */
	public void setFrequencies(double[] frequencies){
		
		for(int i = 0; i < numberOfPoints; i++){
			this.points.get(i).setFrequency(frequencies[i]);
		}
		
	}
	
	/**
	 * Set new Amplitudes to the current Partial.
	 * @param amplitudes
	 */
	public void setAmplitudes(double[] amplitudes){
		
		for(int i = 0; i < numberOfPoints; i++){
			this.points.get(i).setAmplitude(amplitudes[i]);
		}
		
	}
	
	/**
	 * Set new Times to the current Partial.
	 * @param times
	 */
	public void setTimes(double[] times){
		
		for(int i = 0; i < numberOfPoints; i++){
			this.points.get(i).setTime(times[i]);
		}
		
		//NEED TO RECALCULATE START AND END
		
	}
	
}