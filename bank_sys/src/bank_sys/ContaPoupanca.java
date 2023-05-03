package bank_sys;

import java.util.Date;

import utils.Utils;

public class ContaPoupanca extends Conta{
	
	private Date date = new Date();
	private int birthDateAccount = date.getDay(); 
	protected String tipoConta = "Conta Poupanca";

	public ContaPoupanca(User user) {
		super(user);
		this.birthDateAccount = birthDateAccount;
		this.tipoConta = tipoConta;
	}

	public int getBirthDateAccount() {
		return birthDateAccount;
	}

	public void setBirthDateAccount(int birthDateAccount) {
		this.birthDateAccount = birthDateAccount;
	}
	
	public String getTipoConta() {
		return tipoConta;
	}
	
	public String toString() {
		return "\nNome: " + this.user.getName() + 
				"\nNumero da conta: " + this.getNumeroConta() +
				"\nCPF: " + this.user.getCpf() +
				"\nSaldo: " + Utils.doubleToString(getSaldo()) +
				"\nData de criacao da conta: " + this.dataAbertura +
				"\nTipo Conta: " + this.tipoConta +
				"\nLimite de credito: " + this.limiteCredito +
				"\nAniversário Conta:" + this.birthDateAccount +
				"\n";
	}
	
}
