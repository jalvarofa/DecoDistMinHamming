package hamming;
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
		
		
		
		return s;
		
	}
}
