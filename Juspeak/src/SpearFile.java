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
 * SpearFile.java
 * Purpose: Object that contains partials.
 *
 * @author Gabriel Sanchez
 * @version 1.0
 */
public class SpearFile{
	
	String name;
	int numberOfPartials;
	ArrayList<Partial> partials = new ArrayList<Partial>();
	
	/**
	 * Constructor.
	 */
	public SpearFile(){}
	
	/**
	 * Constructor.
	 * @param name
	 * @param numberOfPartials
	 * @param partials
	 */
	public SpearFile(String name, int numberOfPartials, ArrayList<Partial> partials){
		this.name = name;
		this.numberOfPartials = numberOfPartials;
		this.partials = partials;
	}
	
	/**
	 * Get Name.
	 * @return	name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Set Name.
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get Number of Partials.
	 * @return	numberOfPartials
	 */
	public int getNumberOfPartials(){
		return numberOfPartials;
	}

	/**
	 * Set Number of Partials.
	 * @param numberOfPartials
	 */
	public void setNumberOfPartials(int numberOfPartials){
		this.numberOfPartials = numberOfPartials;
	}

	/**
	 * Get Partials.
	 * @return	partials.
	 */
	public ArrayList<Partial> getPartials(){
		return partials;
	}

	/**
	 * Set Partials.
	 * @param partials
	 */
	public void setPartials(ArrayList<Partial> partials){
		this.partials = partials;
	}
	
	/**
	 * Add a Partial.
	 * @param p
	 */
	public void addPartial(Partial p){
		this.partials.add(p);
	}
	
}