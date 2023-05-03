package bank_sys;
import java.math.*;

public class User {
	
	private static int counter = 1;
	
	private String name;
	private String cpf;
	private  String birthDate;

	public User(String name, String cpf, String birthDate) {
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		counter += 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String toString() {
		return "\nNome: " + this.getName() +
				"\nCPF: " + this.getCpf() +
				"\nData de Nascimento: " + this.getBirthDate();
	}
	
}
