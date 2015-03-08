package lab01;


public class Roman {
	
	char[] romansigns = {'I', 'V','X','L','C','D', 'M'};
	String[] romansign = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	
	public String makeitroman(int number){
		String result = "";
		int ind =12;
		if (number > 3999 || number < 1){
			throw new IllegalArgumentException("Invalid number");
			
		
		}
		while(number >= 1000){
			result= result+ romansign[ind];
			number -= 1000;
		}
		if (number<1000){
			ind--;
		}
		
		while(number >= 900){
			result = result+ romansign[ind];	
			number -= 900;
		}
		
		if (number<900){
			ind--;
		}
		
		while (number >= 500) {
			result = result+ romansign[ind];
            number -= 500;
        }
		if (number<500){
			ind--;
		}
		while (number >= 400) {
			result = result+ romansign[ind];
			number -= 400;
        }
		
		if (number<400){
			ind--;
		}
		
		while (number >= 100) {
			result = result+ romansign[ind];
			number -= 100;
        }
		if (number<100){
			ind--;
		}
		
		
		while (number >= 90) {
			result = result+ romansign[ind];
			number -= 90;
        }
		if (number<90){
			ind--;
		}
		
		while (number >= 50) {
			result = result+ romansign[ind];
			number -= 50;
        }
		if (number<50){
			ind--;
		}
		while (number >= 40) {
			result = result+ romansign[ind];
			number -= 40;
        }
		if (number<40){
			ind--;
		}
		while (number >= 10) {
			result = result+ romansign[ind];
			number -= 10;
        }
		if (number<90){
			ind--;
		}
		while (number >= 9) {
			result = result+ romansign[ind];
			number -= 9;
        }
		if (number<9){
			ind--;
		}
		while (number >= 5) {
			result = result+ romansign[ind];
			number -= 5;
        }
		if (number<5){
			ind--;
		}
		while (number >= 4) {
			result = result+ romansign[ind];
			number -= 4;
        }
		if (number<4){
			ind--;
		}
		while (number >= 1) {
			result = result+ romansign[ind];
			number -= 1;
        }
		if (number<1){
			ind--;
		}
		
		
		return result;
	}
}
