import java.util.Scanner;

public class Primary {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conversions convert = new Conversions();
		int select = -1;
		String output = "-1";
		String res = "error";
		
		
//		System.out.println(test.dec_convtb(1023)); //can't go higher than 1,023 in decimal 1,111,111,111, 10 bits in binary
		
		Scanner input = new Scanner(System.in);
		System.out.println("Converting from:");
		System.out.println("1 - binary");
		System.out.println("2 - decimal");
		System.out.println("3 - hedidecimal");
		
		int fchoice = input.nextInt();
		input.nextLine();
		
		switch(fchoice) {
		case 1:
			select = 1;
			break;
		case 2:
			select = 2;
			break;
		case 3:
			select = 3;
			break;
		}
		
		System.out.println("Converting to:");
		System.out.println("1 - binary");
		System.out.println("2 - decimal");
		System.out.println("3 - hedidecimal");
		
		int lchoice = input.nextInt();
		input.nextLine();
		
		switch(lchoice) {
		case 1:
			select = select * 3;
			res = "binary";
			break;
		case 2:
			res = "decimal";
			select = select * 4;
			break;
		case 3:
			res = "hexidecimal";
			select = select * 5;
			break;
		}
		
		System.out.println("Please enter the integer you wish converted.");
		System.out.println("Please note, your number can not excede 1,023 in decimal, or 10 bits in binary.");
		
		String num = input.nextLine();
		//binary decimal hex
		switch(select) {
		case 3:
			output = num;
			break;
		case 4:
			output = convert.bin_convtd(Integer.parseInt(num));
			break;
		case 5:
			output = convert.bin_convth(Integer.parseInt(num));
			break;
		case 6:
			output = convert.dec_convtb(Integer.parseInt(num));
			break;
		case 8:
			output = num;
			break;
		case 9:
			output = convert.hex_convtb(num);
			break;
		case 10:
			output = convert.dec_convth(Integer.parseInt(num));
			break;
		case 12:
			output = convert.hex_convtd(num);
			break;
		case 15:
			output = num;
			break;
		}
		System.out.println("In " + res + " your number is " + output);
	}
}
