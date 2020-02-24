package src.objektorienterat;

public class Main {
	public static void main(String[] args) throws Exception{
		System.out.println("helloworld");
		BackgroundSound backgroundSound=new BackgroundSound();
		backgroundSound.start();
		TreIRad t= new TreIRad();
		t.startGame();
	}
}
