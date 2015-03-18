package com.taj.lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Psik implements Psikus {
	 Random r = new Random();
	public Integer cyfrokrad(Integer number) {
		 String backup;
		 int delete;
		 String result="";
		 Integer resultint;
		 char[] now;
		if(number > 9 || number <-9){
			
			now = new char[Integer.toString(number).length()];
			backup = Integer.toString(number);
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

	public Integer hultajchochla(Integer number) throws NieudanyPsikusException {
		
		if(number < 9 || number >-9)
		{
		throw new NieudanyPsikusException();
		}
		String backup;
		int swap;
		int swap2;
		char tmp;
		String result="";
		Integer resultint;
		//make char arr
		char[] now;
		now = new char[Integer.toString(number).length()];
		backup = Integer.toString(number);
		for(int i = 0 ; i<backup.length() ; i++){
			now[i] = backup.charAt(i);
		}
		//what to change
		swap = r.nextInt(Integer.toString(number).length());
		swap2 = r.nextInt(Integer.toString(number).length());
		while(swap2==swap){
			swap2 = r.nextInt(Integer.toString(number).length());	
		}
		
		//magic happens
		tmp = now[swap];
		now[swap] = now[swap2];
		now[swap2] = tmp;
		
		
		for(int i = 0 ; i < backup.length(); i++){
			result = result + now[i] ;
		}
		
		resultint = Integer.parseInt(result);
	
		return resultint;
	}

	public Integer nieksztaltek(Integer number) {
		List<Integer> myindexs = new ArrayList<Integer>();
		String result="";
		Integer resultint;
		String backup;
		char[] now;
		boolean ifExist= false;
		int howmany=0;
		now = new char[Integer.toString(number).length()];
		backup = Integer.toString(number);
		for(int i = 0 ; i<backup.length() ; i++){
			now[i] = backup.charAt(i);
			if(now[i] == '3' || now[i] == '7' ||now[i] == '6' ){
				ifExist = true;
				howmany++;
				myindexs.add(i);

			}
		}
		if(ifExist == false){
			return number;
		}
		
	
		int change = r.nextInt(howmany);
		if(now[myindexs.get(change)] == '3'){
		now[myindexs.get(change)] = '8';
		}
		else if(now[myindexs.get(change)] == '7'){
			now[myindexs.get(change)] = '1';
			}
		else if(now[myindexs.get(change)] == '6'){
			now[myindexs.get(change)] = '9';
			}
		
		for(int i = 0 ; i < backup.length(); i++){
			result = result + now[i] ;
		}
		resultint = Integer.parseInt(result);
		return resultint;
	}

}
