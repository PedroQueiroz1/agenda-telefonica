package br.com.freyr.excecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AgendaTratamentoExcecao extends ResponseEntityExceptionHandler{
	
	private static final String LENGTH = "Length";
	private static final String NOT_BLANK = "NotBlank";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var erros =gerarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request){
		String msgUsuario="Recurso não encontrado.";
		String msgDesenvolvedor= ex.toString();
		var erros = Arrays.asList(new Erro(msgUsuario,msgDesenvolvedor));
		return handleExceptionInternal(ex,erros,new HttpHeaders(),HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(RegraAgendaException.class)
	public ResponseEntity<Object> handleRegraAgendaException(RegraAgendaException ex, WebRequest request){
		String msgUsuario=ex.getMessage();
		String msgDesenvolvedor= ex.getMessage();
		var erros = Arrays.asList(new Erro(msgUsuario,msgDesenvolvedor));
		return handleExceptionInternal(ex,erros,new HttpHeaders(),HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> gerarListaDeErros(BindingResult bindingResult) {
		var erros = new ArrayList<Erro>();
		bindingResult.getFieldErrors().forEach(fieldError->{
			String msgUsuario = tratarMensagemDeErroParaUsuario(fieldError);
			String msgDesenvolvedor = fieldError.toString();
			erros.add(new Erro(msgUsuario,msgDesenvolvedor));
		});
		return erros;
	}

	private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
		if(fieldError.getCode().equals(NOT_BLANK)) {
			return fieldError.getDefaultMessage().concat(" é obrigatório");
		}
		if(fieldError.getCode().equals(LENGTH)) {
			return fieldError.getDefaultMessage().concat(
					String.format(" é obrigatório ter entre %s e %s caracteres",
							fieldError.getArguments()[2],fieldError.getArguments()[1]));
		}
		return fieldError.toString();
	}

}
