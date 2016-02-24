package concurrent.producer.consumer;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

public class HashedPasswordHackerTest {

	private static final String password = "#edPass1";
	private static final String passwordsHash = "6c8e69629ff154ec36a507118e549f97";
	private List<String> inputPasswordList = asList(shufl(password)
			,shufl(password)
			,shufl(password)
			,password
			,shufl(password));

	@Test
	public void findPasswordByHesh() throws Exception {
		
		assertThat(new PasswordsHashMatcher(
				new PasswordListGenerator(inputPasswordList))
				.find(passwordsHash)
				, equalTo(password));
	}
	
	@Test
	public void initTestPreconditions() throws Exception {
		assertThat(password ,equalTo("#edPass1"));
		assertThat(md5(password),equalTo(passwordsHash));
		//Сгенерировать список паролей для перебора на основе правильного перебора с помощью случайных перестановок
		assertThat(shufl(password),is(not(equalTo(password))));
		
	}
	
	 private String shufl(String password) {
		String shufle = password;
		Random rn = new Random();
		char[] buf = password.toCharArray();
		for(int i = password.length()-1;i>0;i--){
				int selected = rn.nextInt(i);
				char smb = buf[i];
				buf[i] = buf[selected];
				buf[selected]=smb;
		}	
		System.out.println(buf);
		return new String(buf);
	}

	public static String md5(String input)  throws Exception {
         
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
