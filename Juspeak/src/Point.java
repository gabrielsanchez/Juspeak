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

/**
 * CS-12J Asn 3
 * Point.java
 * Purpose: Object that contains partials.
 *
 * @author Gabriel Sanchez
 * @version 1.0
 */
public class Point{

	double time;
	double frequency;
	double amplitude;
	
	/**
	 * Constructor.
	 */
	public Point(){}
	
	/**
	 * Constructor.
	 * @param	time
	 * @param	frequency
	 * @param	amplitude
	 */
	public Point(double time, double frequency, double amplitude){
		this.time = time;
		this.frequency = frequency;
		this.amplitude = amplitude;
	}
	
	/**
	 * Returns time.
	 * @return	time
	 */
	public double getTime(){
		return time;
	}
	
	/**
	 * Sets time.
	 * @param time
	 */
	public void setTime(double time){
		this.time = time;
	}
	
	/**
	 * Get Frequency.
	 * @return	frequency
	 */
	public double getFrequency(){
		return frequency;
	}
	
	/**
	 * Set Frequency.
	 * @param 	frequency
	 */
	public void setFrequency(double frequency){
		this.frequency = frequency;
	}
	
	/**
	 * Get Amplitude.
	 * @return	amplitude
	 */
	public double getAmplitude(){
		return amplitude;
	}
	
	/**
	 * Set Amplitude.
	 * @param amplitude
	 */
	public void setAmplitude(double amplitude){
		this.amplitude = amplitude;
	}
}