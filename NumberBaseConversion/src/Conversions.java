import java.lang.Math;

public class Conversions {
	private int dcounter = 0;
	private double result = 0;
	private int bnum = 0;
	
	public String dec_convtb(int num) {
		int bcounter = 0;
		if (num==0) { //base case
			return "0";
		}else {
			while (Math.pow(2,bcounter) <= num){//counts up to the largest possible number it could be (if number is 10 counts up to 8 (1000))
				bcounter++;
			}
//			System.out.print("test ");
//			System.out.print(bcounter + " ");
			bnum = (int) (bnum + Math.pow(10, bcounter-1));//adds the largest possible number to the binary result
//			System.out.println(bnum);
			dec_convtb((int) (num-Math.pow(2,bcounter-1))); //recursion, sends it down a level by subtracting current binary number from said number
			return String.valueOf(bnum);
		}//^^ if 10 will subtract 8 from 10 to get 2 (the new binary number to search for)
	}
	
	public String hex_convtb(String num) {
		int len = num.length();
		String res = "";
		for(int i = 0; i < len; i++) {//looks at the number starting with the left most
			bnum = 0;
			String dig = "0";
			if(Character.isDigit(num.charAt(i))) {//decides it current character is a digit
				dig = dec_convtb(Character.getNumericValue(num.charAt(i)));//returns the current digit we're converting converted to binary
			}else {//translates hex letters into decimal
				switch(Character.toString(num.charAt(i))) {
				case "A": dig = "10";
					break;
				case "B": dig = "11";
					break;
				case "C": dig = "12";
					break;
				case "D": dig = "13";
					break;
				case "E": dig = "14";
					break;
				case "F": dig = "15";
					break;
				}
				dig = dec_convtb(Integer.parseInt(dig));//converts decimal digits into binary
			}
			String sdig = dig;
			while (sdig.length()<4) {//makes sure it's 4 bits long
				sdig = "0" + sdig;
			}
			res = res + sdig;//creates number
		}
		return res;
	}
	
	
	public String bin_convtd(int num) {
		String wnum = String.valueOf(num); //converts it to a string
		int len = wnum.length()-1; //gets the length of the string (how many digits in the number)
		for(int i = 0; i <= len; i++) { //for loop begin
			int ind = len-i; // gives the index we're looking at
			result = result + (Math.pow(2, i)*(Character.getNumericValue(wnum.charAt(ind))));//multiplies number for that position by whether 1 or 0
			//^^ indexing returns a character which doesn't convert nicely into an int so the char data type needs special treatment
		}
		return String.valueOf(result);
	}
	
	private String bin_convtd(String num) {
		int len = num.length()-1; //gets the length of the string (how many digits in the number)
		for(int i = 0; i <= len; i++) { //for loop begin
			int ind = len-i; // gives the index we're looking at
			result = result + (Math.pow(2, i)*(Character.getNumericValue(num.charAt(ind))));//multiplies number for that position by whether 1 or 0
			//^^ indexing returns a character which doesn't convert nicely into an int so the char data type needs special treatment
		}
		return String.valueOf(result);
	}
	
	
	public String bin_convth(int num){
		boolean ctrl = true;
		int len;
		String end = null;
		String fourBit = "-1";
		String midEnd; //temporarily holds the value of 4 bits
		String wnum = String.valueOf(num); //converts it to a string
		do{
			len = wnum.length()-1; //gets the length of the string (how many digits in the number)
			if(wnum.length() % 4 != 0) {//adds zeros to the front of the number until it is divisible by 4
			wnum = "0" + wnum;
			}
			else
				ctrl = false;
		} while (ctrl);
		for(int j = 0; j <= len/4; j++) {//begin loop breaks into 4 chunks
			//basically passes in 4 bits at a time
			for(int k = 0; k < 4; k++) {//assembling the 4 bit piece
				int ind = len - ((j*4) + k); // gives the index we're looking at, starting on the right
				if(k == 0) {//if it's the first run defines fourBit
					fourBit = String.valueOf(wnum.charAt(ind));
				}
				else {
					fourBit = wnum.charAt(ind) + fourBit;}
			}//end chunking, begin parsing
			result = 0;//clearing previous parsed 4 bits
			for(int i = 0; i < 4; i++) { //converts binary to decimal
				result = result + (Math.pow(2, i)*(Character.getNumericValue(fourBit.charAt(3 - i))));//multiplies number for that position by whether 1 or 0
			}
			midEnd = String.valueOf((int)result);
			if (result>9) {
				switch((int)result) {
				case 10: midEnd =  "A";
					break;
				case 11: midEnd = "B";
					break;
				case 12: midEnd = "C";
					break;
				case 13: midEnd = "D";
					break;
				case 14: midEnd = "E";
					break;
				case 15: midEnd = "F";
					break;
				}
			}
			if(j == 0) {
				end = midEnd;
			}
			else
				end = midEnd + end;
		}//end parsing
		return end;
	}
	
	public String bin_convth(String num) {
		return this.bin_convth(Integer.valueOf(num));
	}
	
	public String dec_convth(int num) {
		String x = dec_convtb(num);
		return (bin_convth(x));
	}
	public String hex_convtd(String num) {
		String x = hex_convtb(num);
//		System.out.println("x = " + x);
		return (bin_convtd(x));
	}
}
