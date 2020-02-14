package src.objektorienterat;

import java.io.IOException;

public class StringInputChecker{
	String string;
	
	StringInputChecker(String string){
		this.string=string;
	}
	StringInputChecker(){
		
	}

	
	public String Check(String string) throws StringEmptyException{
		if(string.length()==0) {
			throw new StringEmptyException("String is empty");
		} 
		return string;
	}
}
