package concurrent.producer.consumer;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;

public class PasswordListGenerator {

	private List<String> inputPasswordList;

	
	public PasswordListGenerator(String password) {

		inputPasswordList = asList(shufl(password)
				,shufl(password)
				,shufl(password)
				,password
				,shufl(password));
	}

	public List<String> getSelectedPasswordsList() {
		
		return inputPasswordList;
	}

	 public static String shufl(String password) {
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
}
