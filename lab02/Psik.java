package lab02;

import java.util.Random;

public class Psik implements Psikus {
	 Random r = new Random();
	 String backup;
	 int delete;
	 String result="";
	 Integer resultint;
	 char[] now;
	 
	 
	public Integer cyfrokrad(Integer liczba) {
	if(liczba > 9 || liczba <-9){
		// TODO Auto-generated method stub
		now = new char[10];
		backup = Integer.toString(liczba);
		delete = r.nextInt(backup.length());
		for(int i = 0 ; i<backup.length() ; i++){
			now[i] = backup.charAt(i);
			
		}
		now[delete] ='A';
		for(int i = 0 ; i < backup.length(); i++){
			if( now[i] != 'A'){
				result = result + now[i] ;
			}
		}
		resultint = Integer.parseInt(result);
		return resultint;
	}
	else
		return null;
	}

	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

}


/*

import java.util.Random;
;
public  class Psik {
	

  public static void main(String[] args) {
     Random r = new Random();
	 String backup;
	 int delete;
	 String result="";
	 Integer resultint;
	 char[] now;
	 now = new char[10];
	 
	 int liczba = 123;
	 if(liczba > 9 || liczba <-9){
		// TODO Auto-generated method stub
		
		backup = Integer.toString(liczba);
		delete = r.nextInt(backup.length());
		for(int i = 0 ; i<backup.length() ; i++){
			now[i] = backup.charAt(i);
			
		}
		now[delete] = 'A';
		for(int i = 0 ; i < backup.length(); i++){
			if( now[i] != 'A'){
				result = result+ now[i] ;
			}
		}
		resultint = Integer.parseInt(result);
    System.out.println(resultint);
  }
}
}
*/