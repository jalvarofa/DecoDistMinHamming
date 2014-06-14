package simulator;

import hamming.HammingDistance;

import java.util.Random;

/**
 * 
 * @author adrian
 *
 */
public class Simulator {

	private HammingDistance hammingDistance;
	
	private float p;
	private int n;
	private int numWords;
	private String[] c;
	
	private int numOk = 0;
	private int numFail = 0;

	public Simulator(String c){
		this.numWords = calculateNumWords(c);
		this.c = createMatrix(c, numWords);
		this.n = this.c[0].length();
		this.p = (1/(float)this.n);
		this.hammingDistance = new HammingDistance(c);
	}
	
	public int calculateNumWords(String s) {
		char toCompare = ';';
		int cont = 1; //iniciamos en 1 ya que siempre habra una palabra mas que el numero de comas
		char[] caracteres = s.toCharArray();

		for (int i = 0; i <= caracteres.length - 1; i++) {
			if (toCompare == caracteres[i]) {
				cont++;
			}
		}
		return cont;
	}
	
	private String[] createMatrix(String c, int n) {
		String[] aux1 = c.split(";");
		return aux1;
	}
	
	/**
	 * this method simulate the sending of one word
	 */
	public void simulateOneWord(){
		int random = (int)Math.random()*(numWords-1);
		String word = c[random];
		char[] simbols = word.toCharArray();
		StringBuffer buffer = new StringBuffer();
		
		//simulamos la probabilidad de ruido de un canal
		for (int i = 0; i < simbols.length; i++) {
			if(Math.random() < p){
				if(simbols[i] == '0'){
					simbols[i] = '1';
				}else{
					simbols[i] = '0';
				}
			}
			buffer.append(simbols[i]);
		}
		System.out.println(word);
		word = buffer.toString();
		System.out.println(word);
		
		//enviamos la palabra al descodificador
		String descodifiedWord = hammingDistance.decoderAuto(word);
		System.out.println(descodifiedWord);
	}
	
	/**
	 * simulate the sending of numSimulations words
	 * @param numSimulations (the number of simulations)
	 */
	public void simulateWords(int numSimulations){
		int count = 0;
		String word;
		char[] simbols;
		StringBuffer buffer;
		
		while(count < numSimulations){
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			int random = (int)(Math.random()*(numWords-1));
			System.out.println(random);
			word = c[random];
			simbols = word.toCharArray();
			buffer = new StringBuffer();
			
			for (int i = 0; i < simbols.length; i++) {
				if(Math.random() < p){
					if(simbols[i] == '0'){
						simbols[i] = '1';
					}else{
						simbols[i] = '0';
					}
				}
				buffer.append(simbols[i]);
			}
			System.out.println("codigo: " + word);
			String wordTransmited = buffer.toString();
			System.out.println("palabra transmitida: " + wordTransmited);
			
			//enviamos la palabra al descodificador
			String descodifiedWord = hammingDistance.decoderAuto(wordTransmited);
			System.out.println("palabra descodificada: " + descodifiedWord);
			
			if(word.compareTo(descodifiedWord) == 0){
				numOk++;
				System.out.println("OK");
			}else{
				numFail++;
				System.out.println("FAIL");
			}
			
			count++;
		}
	}
	
	public float getpercentageOk(){
		System.out.println("numOk: " + numOk);
		System.out.println("numFail: " + numFail);
		return (float)numOk/(float)(numOk+numFail);
	}
	
	public float getP() {
		return p;
	}

	public void setP(float p) {
		this.p = p;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getNumWords() {
		return numWords;
	}

	public void setNumWords(int numWords) {
		this.numWords = numWords;
	}

	public int getNumFail() {
		return numFail;
	}

	public void setNumFail(int numFail) {
		this.numFail = numFail;
	}

	public int getNumOk() {
		return numOk;
	}
	
	
}
