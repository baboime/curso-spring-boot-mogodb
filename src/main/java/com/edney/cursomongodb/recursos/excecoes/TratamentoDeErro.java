package com.edney.cursomongodb.recursos.excecoes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.edney.cursomongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@ControllerAdvice
public class TratamentoDeErro {
	
	@ExceptionHandler(ExcecaoObjetoNaoEncontrado.class)
	public ResponseEntity<PadraoDeErro> objetoNaoEncontrato(ExcecaoObjetoNaoEncontrado e, HttpServletRequest requisicao) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;	
		
		PadraoDeErro erro = new PadraoDeErro(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), requisicao.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
}
