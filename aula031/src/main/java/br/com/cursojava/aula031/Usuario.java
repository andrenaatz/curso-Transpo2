package br.com.cursojava.aula031;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "usuario" )
//	@JoinColumn(name="usuario_id")
	private List<Tarefa> tarefas;
	
	@ElementCollection(targetClass = PerfilUsuario.class)
	@Enumerated(EnumType.STRING)
	private Set<PerfilUsuario> perfis;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String nome, String email, List<Tarefa> tarefas, PerfilUsuario ...perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tarefas = tarefas;
		if(perfis != null && perfis.length > 0){
			this.perfis = new HashSet<>();
			for (PerfilUsuario perfilUsuario : perfis) {
				this.perfis.add(perfilUsuario);
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Set<PerfilUsuario> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<PerfilUsuario> perfis) {
		this.perfis = perfis;
	}
	public boolean addPerfil(PerfilUsuario perfil){
		if(this.perfis == null){
			this.perfis = new HashSet<>();
		}
		return this.perfis.add(perfil);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", tarefas=" + tarefas + "]";
	}
	
	

}
