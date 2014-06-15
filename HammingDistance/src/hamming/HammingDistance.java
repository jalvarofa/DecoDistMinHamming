package hamming;

import java.util.ArrayList;

public class HammingDistance {

	/**
	 * Codigo C
	 */
	private String code[];
	private int numWords;

	public HammingDistance(String c) {
		this.numWords = calculateNumWords(c);
		this.code = createMatrix(c, this.numWords);
	}

	/**
	 * 
	 * @param c
	 * @param n
	 * @return
	 */
	private String[] createMatrix(String c, int n) {
		// TODO Auto-generated method stub
		// int[][] aux = new int[c.length()/n][n];
		// int index = 0;
		// String[] aux1 = new String[numWords(c)+1];

		String[] aux1 = c.split(";");
		// String[][] aux2 = new String[aux1.length][];
		// for (int row = 0; row < aux1.length; row++) {
		// aux2[row] = aux1[row].split(",");
		// for (int column = 0; column < n; column++) {
		// aux[row][column] = Integer.parseInt(String.valueOf(c.charAt(index)));
		// if (column!=n) {
		// index++;
		// }
		// }
		// }
		return aux1;
	}

	/**
	 * 
	 * @return
	 */
	public int getMinimumDistance() {
		int minDistance = Integer.MAX_VALUE;
		int counter = 0;

		for (int i = 1; i < this.code.length; i++) {
			counter = 0;
			for (int j = 1; j <= this.code[i].length(); j++) {
				if (this.code[i - 1].charAt(j - 1) != this.code[i]
						.charAt(j - 1)) {
					counter++;
				}
			}

			if (counter == 0)
				return counter;
			if (counter < minDistance)
				minDistance = counter;
		}

		return minDistance;

	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public int getMinimumDistance(String s) {
		int minDistance = Integer.MAX_VALUE;
		int counter = 0;
		String[] aux = createMatrix(s, calculateNumWords(s));

		for (int i = 1; i < aux.length; i++) {
			counter = 0;
			for (int j = 1; j <= aux[i].length(); j++) {
				if (aux[i - 1].charAt(j - 1) != aux[i]
						.charAt(j - 1)) {
					counter++;
				}
			}

			if (counter == 0)
				return counter;
			if (counter < minDistance)
				minDistance = counter;
		}

		return minDistance;
	}

	/**
	 * 
	 */
	public void show() {
		// for (int i = 0; i < this.code.length; i++) {
		// for (int j = 0; j < this.code[i].length; j++) {
		// System.out.print("["+this.code[i][j]+"]");
		// if (j==this.code[i].length-1) {
		// System.out.println();
		// }
		// }
		// }
		for (int i = 0; i < this.code.length; i++) {
			for (int j = 0; j < this.code[i].length(); j++) {
				System.out.print("[" + this.code[i].charAt(j) + "]");
				if (j == this.code[i].length() - 1) {
					System.out.println();
				}
			}
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
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
	
	public String decoderAuto(String s) {
		String auxCode = null;
		String wordDecoded = null;
		int min = Integer.MAX_VALUE;
		int minDistance = 0;
		ArrayList<String> decodedWords = new ArrayList<String>();
		int random = 0;
		
		for (int i = 0; i < this.code.length; i++) {
			auxCode = s+";"+this.code[i];
			minDistance = getMinimumDistance(auxCode);
			
			if (minDistance < min) {
				decodedWords.clear();
				decodedWords.add(this.code[i]);
				min = minDistance;
			}else if (minDistance == min) {
				decodedWords.add(this.code[i]);
			}
		}
		
		if (decodedWords.size() > 1) {
			
			random  = (int) Math.floor(Math.random()*decodedWords.size());
			
			wordDecoded = decodedWords.get(random);
		}else{
			wordDecoded = decodedWords.get(0);
		}
		
		return wordDecoded;
		
	}

	public String[] getCode() {
		return code;
	}

	public void setCode(String s) {
		String[] newCode = createMatrix(s, calculateNumWords(s));
		this.code = newCode;
	}

	public int getNumWords() {
		return numWords;
	}

	public void setNumWords(int numWords) {
		this.numWords = numWords;
	}
}
