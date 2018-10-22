package br.com.cursojava.aula029;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements RepositorioContato{

	private static final String COUNT_ALL = "select count(*) as quantidade from contatos";
	private static final String DELETE = "delete from contatos  where id = ?";
	private static final String UPDATE = "update contatos set nome = ?, email = ?, telefone = ?  where id = ?";
	private static final String INSERT = "insert into contatos(nome, email, telefone) values(?,?,?)";
	private static final String SELECT_BY_ID = "select * from contatos where id = ?";
	private static final String SELECT_BY_PHONE = "select * from contatos where telefone = ?";
	private static final String SELECT_BY_NAME = "select * from contatos where upper(nome) like upper(?)";
	private static final String SELECT_ALL = "select * from contatos";

	@Override
	public List<Contato> buscarTodos() {
		List<Contato> contatos = new ArrayList<>();
		try {
			Connection conexao = BancoUtils.getConnection();
			PreparedStatement comando = conexao.prepareStatement(SELECT_ALL);
			ResultSet cursor = comando.executeQuery();
			while (cursor.next()) {
				contatos.add(carregarContato(cursor));
			}
			cursor.close();
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível carregar a lista de contatos");
		}

		return contatos;
	}

	private Contato carregarContato(ResultSet cursor) throws SQLException {
		Integer id = cursor.getInt("id");
		String nome = cursor.getString("nome");
		String email = cursor.getString("email");
		String telefone = cursor.getString("telefone");
		return new Contato(id, nome,email,telefone);
	}

	@Override
	public List<Contato> buscarPorNome(String nome) {
		List<Contato> contatos = new ArrayList<>();
		try {
			Connection conexao = BancoUtils.getConnection();
			PreparedStatement comando = conexao.prepareStatement(SELECT_BY_NAME );
			comando.setString(1, "%"+nome+"%");
			ResultSet cursor = comando.executeQuery();
			while (cursor.next()) {
				contatos.add(carregarContato(cursor));
			}
			cursor.close();
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível carregar a lista de contatos por nome");
		}
		return contatos;

	}

	@Override
	public Contato buscarPorTelefone(String telefone) {
		Contato contato = null;
		try {
			Connection conexao = BancoUtils.getConnection();
			PreparedStatement comando = conexao.prepareStatement(SELECT_BY_PHONE);
			comando.setString(1, telefone);
			ResultSet cursor = comando.executeQuery();
			if (cursor.next()) {
				contato = carregarContato(cursor);
			}
			cursor.close();
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível carregar o contato por telefone");
		}

		return contato;
	}

	@Override
	public Contato buscarPorId(Integer id) {
		Contato contato = null;
		try {
			Connection conexao = BancoUtils.getConnection();
			PreparedStatement comando = conexao.prepareStatement(SELECT_BY_ID);
			comando.setInt(1, id);
			ResultSet cursor = comando.executeQuery();
			if (cursor.next()) {
				contato = carregarContato(cursor);
			}
			cursor.close();
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível carregar o contato por id");
		}

		return contato;
	}

	@Override
	public void inserir(Contato contato) {
		if(contato != null){
			try {
				Connection conexao = BancoUtils.getConnection();
				PreparedStatement comando = conexao.prepareStatement(INSERT,
						                                              Statement.RETURN_GENERATED_KEYS);
				comando.setString(1, contato.getNome());
				comando.setString(2, contato.getEmail());
				comando.setString(3, contato.getTelefone());
				comando.execute();
				ResultSet cursor = comando.getGeneratedKeys();
				if(cursor.next()){
					Integer id = cursor.getInt("id");
					contato.setId(id);
				}
				cursor.close();
				comando.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível inserir os dados do Contato");
			}
		}
		
	}

	@Override
	public void atualizar(Contato contato) {
		if(contato != null && contato.getId() != null){
			try {
				Connection conexao = BancoUtils.getConnection();
				PreparedStatement comando = conexao.prepareStatement(UPDATE);
				comando.setString(1, contato.getNome());
				comando.setString(2, contato.getEmail());
				comando.setString(3, contato.getTelefone());
				comando.setInt(4, contato.getId());
				comando.executeUpdate();
				comando.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível atualizar os dados do Contato");
			}
		}
		
	}

	@Override
	public void remover(Integer id) {
		if(id != null){
			try {
				Connection conexao = BancoUtils.getConnection();
				PreparedStatement comando = conexao.prepareStatement(DELETE);
				comando.setInt(1, id);
				comando.execute();
				comando.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível remover os dados do Contato");
			}
		}
		
	}

	@Override
	public int contar() {
		int quantidade = 0;
		try {
			Connection conexao = BancoUtils.getConnection();
			PreparedStatement comando = conexao.prepareStatement(COUNT_ALL);
			ResultSet cursor = comando.executeQuery();
			if (cursor.next()) {
				quantidade = cursor.getInt("quantidade");
			}
			cursor.close();
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível contar a quantidade de contatos");
		}

		return quantidade;
	}

}
