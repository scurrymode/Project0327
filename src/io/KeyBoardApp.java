/*
FileInputStream 등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만, 키보드와 같은 표준 입력 하드웨어와 같은 경우엔 자바가 스트림을 생성하지 못하고 해당 OS가 관리하므로,
자바 개발자는 OS로 부터 표준입력 스트림을 얻어올 수 밖에 없다.
*/

package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;


class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;
		 
		//문자기반 스트림은 단독으로 존재하는 것이 아니라, 이미 바이트기반 스트림을 전제로 한다. 따라서 거의 생성자의 인수에 바이트기반 스트림을 넣는 경우가 많다.
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		


		int data;
		try{
			while(true){
				data=reader.read(); //2byte 읽어드림 즉, 한글은 안깨짐 is.read()하면 1byte 읽어드려서 한글 깨짐
				System.out.print((char)data);
			}
		}catch(IOException e){
			
		}


	}

}
