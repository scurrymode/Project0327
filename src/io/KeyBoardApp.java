/*
FileInputStream ���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������, Ű����� ���� ǥ�� �Է� �ϵ����� ���� ��쿣 �ڹٰ� ��Ʈ���� �������� ���ϰ� �ش� OS�� �����ϹǷ�,
�ڹ� �����ڴ� OS�� ���� ǥ���Է� ��Ʈ���� ���� �� �ۿ� ����.
*/

package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;


class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;
		 
		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�, �̹� ����Ʈ��� ��Ʈ���� ������ �Ѵ�. ���� ���� �������� �μ��� ����Ʈ��� ��Ʈ���� �ִ� ��찡 ����.
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		


		int data;
		try{
			while(true){
				data=reader.read(); //2byte �о�帲 ��, �ѱ��� �ȱ��� is.read()�ϸ� 1byte �о����� �ѱ� ����
				System.out.print((char)data);
			}
		}catch(IOException e){
			
		}


	}

}
