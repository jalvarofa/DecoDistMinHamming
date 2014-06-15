package UI;

import javax.swing.JPanel;

import hamming.HammingDistance;
import simulator.Simulator;

public class UI {
	
	public HammingDistance hammingDistance;
	public Simulator simulator;
	
	public UI(String c){
		this.hammingDistance = new HammingDistance(c);
		this.simulator = new Simulator(c);
	}
	
	public int getMinimumDistance(){
		return this.hammingDistance.getMinimumDistance();
	}
	
	public int getMinimumDistance(String s){
		return this.getMinimumDistance(s);
	}
	
	public void simulateOneWord(){
		this.simulator.simulateOneWord();
	}
	
	public void simulateWords(int numSimulations){
		this.simulator.simulateWords(numSimulations);
	}
	
	

}
