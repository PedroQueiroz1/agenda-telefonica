package br.com.freyr.excecao;

/*
 * Classe necessária para realizar a separação dos erros,
 * para o usuário e para o desenvolvedor.
 */

public class Erro {
	
	private String msgUsuario;
	
	private String msgDesenvolvedor;
	
	public Erro(String msgUsuario, String msgDesenvolvedor) {
		this.msgUsuario = msgUsuario;
		this.msgDesenvolvedor = msgDesenvolvedor;
	}

	public Erro() {
	}

	public String getMsgUsuario() {
		return msgUsuario;
	}

	public void setMsgUsuario(String msgUsuario) {
		this.msgUsuario = msgUsuario;
	}

	public String getMsgDesenvolvedor() {
		return msgDesenvolvedor;
	}

	public void setMsgDesenvolvedor(String msgDesenvolvedor) {
		this.msgDesenvolvedor = msgDesenvolvedor;
	}
	
	

}
