public class Data {

	int quid1;
	int quid2;
	String sd;
	
	/**
	 * Fabrique 
	 * @param quid1
	 * @param qui2
	 * @param sd
	 */
	public Data(int quid1, int quid2, String sd){
		this.quid1 = quid1;
		this.quid2 = quid2;
		this.sd = sd;
	}

	/**
	 * @return the quid1
	 */
	public int getQuid1() {
		return this.quid1;
	}

	/**
	 * @param quid1 the quid1 to set
	 */
	public void setQuid1(int quid1) {
		this.quid1 = quid1;
	}

	/**
	 * @return the quid2
	 */
	public int getQuid2() {
		return this.quid2;
	}

	/**
	 * @param quid2 the quid2 to set
	 */
	public void setQuid2(int quid2) {
		this.quid2 = quid2;
	}

	/**
	 * @return the sd
	 */
	public String getSd() {
		return this.sd;
	}

	/**
	 * @param sd the sd to set
	 */
	public void setSd(String sd) {
		this.sd = sd;
	}

	/**
	 * 
	 */
	public String toString() {
		return "Data [quid1=" + quid1 + ", quid2=" + quid2 + ", sd=" + sd + "]";
	}
	
	
	
}
