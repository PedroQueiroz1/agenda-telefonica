package br.com.freyr.excecao;

public class RegraAgendaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraAgendaException(String mensagem) {
		super(mensagem);
	}
}
