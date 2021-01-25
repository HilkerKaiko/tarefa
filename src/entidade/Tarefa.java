package entidade;

import java.io.Serializable;
import java.util.Date;


public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private Integer minutosTrabalhado;
	
	private String observacao;
	
	private Date dataCriacao;
	
	private Long idUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getMinutosTrabalhado() {
		return minutosTrabalhado;
	}

	public void setMinutosTrabalhado(Integer minutosTrabalhado) {
		this.minutosTrabalhado = minutosTrabalhado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", minutosTrabalhado="
				+ minutosTrabalhado + ", observacao=" + observacao + ", dataCriacao=" + dataCriacao + ", idUsuario="
				+ idUsuario + "]";
	}
	
}
