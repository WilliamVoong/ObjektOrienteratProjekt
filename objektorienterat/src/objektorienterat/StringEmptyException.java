package src.objektorienterat;

public class StringEmptyException extends Exception {
	
	StringEmptyException(String string){
			super("the String is empty Insert a nonempty string", new Throwable());
	}

}
