package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

public abstract class Dao<T> {
	//elementos de acesso
	protected Connection cn; //mantem a conexão com o BD
	protected PreparedStatement stmt; //permite operações no BD
	protected ResultSet rs; //referencia a consulta
	
	//string de conexão jdbc - mysql
	private String conexao = "jdbc:mysql://localhost:3306/dbeventos";
	
	
	
	public void abrirConexao( )  throws Exception{
	
			Class.forName("com.mysql.jdbc.driver");
		   cn = DriverManager.getConnection(conexao,"root","fiap");
		
	}

	public void fecharConexao( ) throws Exception{
		if (cn != null && ! cn.isClosed()) {
			cn.close();	
		}
		
	}
	
	
	public abstract void incluir(T elemento)throws Exception;
	public abstract T buscarr(int id)throws Exception; 
	public abstract Set<T> listar(int... param)throws Exception; 
	
	/*
	 * listar()
	 * listar(1)
	 * listar(1,4,5,9)
	 * 
	 */
	
	
}
