package concurrent.producer.consumer;

import java.util.List;

public class PasswordListGenerator {

	private List<String> inputPasswordList;

	public PasswordListGenerator(List<String> inputPasswordList) {
		this.inputPasswordList = inputPasswordList;
		// TODO Auto-generated constructor stub
	}

	public List<String> getSelectedPasswordsList() {
		
		return inputPasswordList;
	}

}
