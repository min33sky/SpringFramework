package chap02;

import org.junit.Test;

public class Start extends Thread{
	static int share;
	
	public static void main(String[] args) {
		Start t1 = new Start();
		Start t2 = new Start();
		
		t1.start();
		t2.start();
	}
	
	@Override
	public void run() {
		for(int count=0; count<10; count++){
			System.out.println(share++);
			
			try{
				sleep(1000);
			}catch(InterruptedException e){
				
			}
		}
	}
	
}
