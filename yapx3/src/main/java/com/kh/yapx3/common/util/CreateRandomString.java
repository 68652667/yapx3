package com.kh.yapx3.common.util;

import java.util.Random;

public class CreateRandomString {
	
	public String create( int len ) {
		String str = "";
		
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for( int i = 0 ; i < len ; ++i ) {
			int rIndex = rnd.nextInt( 3 );
			switch( rIndex ) {
			case 0:
				temp.append( (char)((int)( rnd.nextInt(26)) + 97 ) );
				break;
			case 1:
				temp.append( (char)((int)( rnd.nextInt(26)) + 65 ) );
				break;
			case 2:
				temp.append( rnd.nextInt(10) );
				break;
			}
		}
		
		str = temp.toString();
		
		return str;
	}
}
