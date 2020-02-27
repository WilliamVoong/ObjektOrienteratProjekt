package src.objektorienterat;

public class StringEmptyException extends Exception {
	private static final long serialVersionUID = 1L;

	StringEmptyException(String string){
			super("the String is empty Insert a nonempty string", new Throwable());
	}

}
