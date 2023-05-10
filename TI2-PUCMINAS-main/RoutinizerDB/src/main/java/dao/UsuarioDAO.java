package dao;

import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends DAO {	
	public UsuarioDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {
			String sql = "INSERT INTO usuario (id, login, senha, nome, email) "
		               + "VALUES ('" + usuario.getId() + "', "
		               + usuario.getLogin() + ", " + usuario.getSenha() + ", " + usuario.getNome() + ", " + usuario.getSenha() + ", " + usuario.getNome() + ", " + usuario.getEmail() + ");";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Usuario get1(String id) {
		Usuario usuario= null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 usuario = new Usuario(rs.getString("id"), rs.getString("login"), rs.getString("senha"), 
	                				   rs.getString("nome"), 
	        			               rs.getString("email"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}
	
	
	public List<Usuario> get() {
		return get("");
	}

	
	public List<Usuario> getOrderByID() {
		return get("id");		
	}
	
	
	public List<Usuario> getOrderByLogin() {
		return get("login");		
	}
	
	
	public List<Usuario> getOrderBySenha() {
		return get("senha");		
	}
	
	public List<Usuario> getOrderByNome() {
		return get("nome");
	}
	
	public List<Usuario> getOrderByEmail() {
		return get("email");
	}
	
	private List<Usuario> get(String orderBy) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Usuario p = new Usuario(rs.getString("id"), rs.getString("login"), rs.getString("senha"), 
     				   rs.getString("nome"), 
		               rs.getString("email"));
	            usuarios.add(p);
	        }	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
	
	
	public boolean update(Usuario usuario) {
		boolean status = false;
		try {  
			String sql = "UPDATE produto SET login = '" + usuario.getLogin() + "', "
					   + "senha = " + usuario.getSenha() + ", " 
					   + "nome = " + usuario.getNome() + ","
					   + "email = " + usuario.getEmail() + "WHERE id = " + usuario.getId();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM produto WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}