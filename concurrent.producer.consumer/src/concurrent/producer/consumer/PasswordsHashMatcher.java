package concurrent.producer.consumer;

public class PasswordsHashMatcher {

	private PasswordListGenerator passwordListGenerator;

	public PasswordsHashMatcher(PasswordListGenerator passwordListGenerator) {
		this.passwordListGenerator = passwordListGenerator;
	}

	public String find(String passwordshash) throws Exception {
		for(String expected:passwordListGenerator.getSelectedPasswordsList()){
			if(passwordshash.equals(Encoder.md5(expected)))
				return expected;
		}
		return null;
	}
}
