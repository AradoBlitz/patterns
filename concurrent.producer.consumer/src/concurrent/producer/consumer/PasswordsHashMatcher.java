package concurrent.producer.consumer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordsHashMatcher {

	private PasswordListGenerator passwordListGenerator;

	public PasswordsHashMatcher(PasswordListGenerator passwordListGenerator) {
		this.passwordListGenerator = passwordListGenerator;
	}

	public String find(String passwordshash) throws Exception {
		for(String expected:passwordListGenerator.getSelectedPasswordsList()){
			if(passwordshash.equals(md5(expected)))
				return expected;
		}
		return null;
	}

	private String md5(String input) throws Exception {
		 String md5 = null;
         
	        if(null == input) return null;
	         
	        	             
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	         
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	 
	        //Converts message digest value in base 16 (hex) 
	        md5 = new BigInteger(1, digest.digest()).toString(16);

	        return md5;
	}

}
