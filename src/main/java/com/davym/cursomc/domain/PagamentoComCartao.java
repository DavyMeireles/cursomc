package com.davym.cursomc.domain;

import javax.persistence.Entity;

import com.davym.cursomc.domain.enuns.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numparcelas;
	
	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numparcelas) {
		super(id, estado, pedido);
		this.numparcelas = numparcelas;
	}

	public Integer getNumparcelas() {
		return numparcelas;
	}

	public void setNumparcelas(Integer numparcelas) {
		this.numparcelas = numparcelas;
	}

	
}
