package UI;

import hamming.HammingDistance;
import simulator.Simulator;

public class UI {
	
	public HammingDistance hammingDistance;
	public Simulator simulator;
	
	public UI(String s){
		this.hammingDistance = new HammingDistance(s);
		this.simulator = new Simulator(s);
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
	
	public String decoderAuto(String c){
		return this.hammingDistance.decoderAuto(c);
	}
	
	

}
