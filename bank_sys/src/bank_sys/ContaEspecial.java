package bank_sys;

import utils.Utils;

public class ContaEspecial extends Conta {
	
	protected String tipoConta = "Conta Especial";
	private Double limiteCredito;
	
	public ContaEspecial(User user, Double limiteCredito) {
		super(user);
		this.tipoConta = tipoConta;
		this.limiteCredito = limiteCredito;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	public String getTipoConta() {
		return tipoConta;
	}
	
	
	public void sacar (Double valor) {
		if(valor > 0 && this.saldo - valor >= (-limiteCredito)) {
			setSaldo(getSaldo() - valor);
			System.out.println("Seu saque foi realizado com sucesso");
		} else {
			System.out.println("Não foi possivel realizar saque");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.saldo - valor >= (-limiteCredito)) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Sua transferencia foi realizada com sucesso");
				
		} else {
			System.out.println("Não foi possivel realizar a transferencia");

		}
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

}
