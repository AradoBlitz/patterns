package concurrent.producer.consumer;

import java.util.List;

public class PasswordListGenerator {

	private List<String> inputPasswordList;

	public PasswordListGenerator(List<String> inputPasswordList) {
		this.inputPasswordList = inputPasswordList;
	}

	public List<String> getSelectedPasswordsList() {
		
		return inputPasswordList;
	}

}
