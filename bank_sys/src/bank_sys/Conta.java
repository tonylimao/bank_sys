package bank_sys;

import java.util.Date;

import utils.Utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	protected User user;
	protected Double saldo = 0.0;
	protected Date dataAbertura;
	protected String tipoConta = "Conta Comum";
	protected Double limiteCredito;
	
	public Conta(User user) {
		this.numeroConta = contadorDeContas;
		this.user = user;
		this.saldo = saldo;
		this.dataAbertura = new Date();
		this.tipoConta = tipoConta;
		this.limiteCredito = 0.0;
		contadorDeContas += 1;
	}
	
	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public Double getLimiteCredito() {
		return limiteCredito;
	}
	public static int getContadorDeContas() {
		return contadorDeContas;
	}
	public static void setContadorDeContas(int contadorDeContas) {
		Conta.contadorDeContas = contadorDeContas;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
				"\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso");
		} else {
			System.out.println("Não foi possível realizar depósito");
		}
	}
	
	public void sacar (Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
		} else {
			System.out.println("Não foi possível realizar saque");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Sua transferencia foi realizada com sucesso");
				
		} else {
			System.out.println("Não foi possível realizar a transferencia");

		}
	}
}
	

