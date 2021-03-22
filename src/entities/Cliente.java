package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	@SuppressWarnings("unused")
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String nomeCliente;
	private String email;
	private Date dataNasc;
	
	public Cliente() {
		
	}

	public Cliente(String nomeCliente, String email, Date dataNasc) {
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.dataNasc = dataNasc;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	
	
}
