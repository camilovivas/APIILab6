package model;

import java.io.Serializable;

public class Hall implements Serializable, Comparable<Hall> {
	private String name;
	private double score;

	
	public Hall(String name, double score) {
		this.name = name;
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	@Override
	public int compareTo(Hall arg) {
		int retorno =0;
		if(score == arg.getScore()) {
			retorno =0;
		}
		else if(score > arg.getScore()) {
			retorno = 1;
		}
		else {
			retorno = -1;
		}
		return retorno;
	}
	
	
	
	
}
