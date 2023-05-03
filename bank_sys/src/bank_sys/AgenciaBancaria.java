package bank_sys;

import java.util.*;

public class AgenciaBancaria {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String args[]) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("-----------------------------------------------------");
		System.out.println("---------------Bem vindo ao Sys Bank-----------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----Selecione uma operacao que deseja realizar------");
		System.out.println("-----------------------------------------------------");
		System.out.println("|1 - Criar conta|");
		System.out.println("|2 - Saldo|");
		System.out.println("|3 - Informacoes da Conta|");
		System.out.println("|4 - Alterar Limite|");
		System.out.println("|5 - Depositar|");
		System.out.println("|6 - Sacar|");
		System.out.println("|7 - Transferir|");
		System.out.println("|8 - Listar|");
		System.out.println("|9 - Sair|");
		
		int operacao = input.nextInt();
		
		switch(operacao) {
		case 1: 
			criarConta();
			break;
		case 2: 
			verSaldo();
			break;
		case 3: 
			infoConta();
			break;
		case 4: 
			alterarLimite();
			break;
		case 5: 
			depositar();
			break;
		case 6: 
			sacar();
			break;
		case 7: 
			transferir();
			break;
		case 8: 
			listarContas();
			break;
		case 9: 
			System.out.println("Obrigado pro usar nosso banco!");
			System.exit(0);
			break;
		default:
			System.out.println("Opcao invalida!");
			operacoes();
		}
	}

	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
			operacoes();
		} else {
			System.out.println("Não há contas cadastradas");
			operacoes();
		}
	}

	public static void transferir() {
		System.out.println("Numero da conta do remetente: ");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Numero da conta do destinatário: ");
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Qual o valor deseja transferir?");
				Double valorTransferencia = input.nextDouble();
				contaRemetente.transferir(contaDestinatario, valorTransferencia);
				operacoes();
			} else {
				System.out.println("Conta destinatária não encontrada.");
				operacoes();
			}
		} else {
			System.out.println("Conta remetente não encontrada.");
			operacoes();
		}
		
	}

	public static void sacar() {
		System.out.println("Numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual o valor deseja sacar?");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			operacoes();
		} else {
			System.out.println("Conta não encontrada.");
			operacoes();
		}
	}

	public static void depositar() {
		System.out.println("Numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual o valor deseja depositar?");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
			operacoes();
		} else {
			System.out.println("Conta não encontrada.");
			operacoes();
		}
	}

	public static void criarConta() {
		System.out.println("\nNome: ");		
		String nome = input.next();
		System.out.println("\nCPF: ");		
		String cpf = input.next();
		System.out.println("\nData de nascimento: ");		
		String dataNasc = input.next();
		
		System.out.println("Qual o tipo de Conta que deseja criar: ");
		System.out.println("1 - Conta Comum");
		System.out.println("2 - Conta Especial");
		System.out.println("3 - Conta Poupanca");
		int tipoConta = input.nextInt();
		
		if(tipoConta == 1) {
			User user = new User(nome, cpf, dataNasc);
			Conta conta = new Conta(user);
			
			contasBancarias.add(conta);
			System.out.println("Sua conta foi criada com sucesso");
			operacoes();
		} else if (tipoConta == 2) {
			System.out.println("Digite o limite de crédito: ");
			Double limiteCredito = input.nextDouble();
			User user = new User(nome, cpf, dataNasc);
			ContaEspecial conta = new ContaEspecial(user, limiteCredito);
			
			contasBancarias.add(conta);
			System.out.println("Sua conta foi criada com sucesso");
			operacoes();
		} else if(tipoConta == 3){
			User user = new User(nome, cpf, dataNasc);
			ContaPoupanca conta = new ContaPoupanca(user);
			
			contasBancarias.add(conta);
			System.out.println("Sua conta foi criada com sucesso");
			operacoes();
		}
	}
	
	public static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}
	
	public static void verSaldo() {
		System.out.println("Qual o numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Saldo: " + conta.getSaldo());
			operacoes();
		} else {
			System.out.println("Conta não encontrada.");
			operacoes();
		}
	}
	
	public static void infoConta() {
		System.out.println("Qual o numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Info conta:\n " + conta.toString());
			operacoes();
		} else {
			System.out.println("Conta não encontrada.");
			operacoes();
		}
	}
	
	public static void alterarLimite() {
		System.out.println("Qual o numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		System.out.println(conta.getTipoConta());
		System.out.println("Press Any Key To Continue...");
        input.nextLine();	
        
		if(conta.getTipoConta() == "Conta Especial") {
			System.out.println("Insira o novo valor do limite de credito: ");
			Double limiteCredito = input.nextDouble();
			
			conta.setLimiteCredito(limiteCredito);
			operacoes();

		} else {
			
			System.out.println("Sua conta não possui limite de credito.");
			operacoes();
		}
	}
}
