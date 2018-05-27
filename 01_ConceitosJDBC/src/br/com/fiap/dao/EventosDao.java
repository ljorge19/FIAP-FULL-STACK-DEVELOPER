package br.com.fiap.dao;

import java.util.HashSet;
import java.util.Set;

import br.com.fiap.entity.Evento;

public class EventosDao extends Dao<Evento> {

	@Override
	public void incluir(Evento elemento) throws Exception{
		try {
			abrirConexao();
			String sql = " INSERT INTO"
					   + " EVENTOS (DESCRICAO,DATA,RESPONSAVEL"
					   + " ) VALUES (?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, elemento.getDescricao());
			stmt.setDate(2, new java.sql.Date(elemento.getData().getTime()));
			stmt.setString(3, elemento.getResponsavel());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
	}

	@Override
	public Evento buscar(int id) throws Exception {
		Evento evento = null;
		
		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM EVENTOS WHERE ID=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				evento = new Evento();
				evento.setId(id);
				evento.setDescricao(rs.getString("DESCRICAO"));
				evento.setData(rs.getDate("DATA"));
				evento.setResponsavel(rs.getString("RESPONSAVEL"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return evento;
	}

	@Override
	public Set<Evento> listar(int... param) throws Exception {
		Set<Evento> lista = new HashSet<>();
		try {
			if(param.length > 0) {
				throw new 
					Exception("Não é permitido parâmetro neste método");
			}
			
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM EVENTOS");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Evento evento = new Evento();
				evento.setId(rs.getInt("ID"));
				evento.setDescricao(rs.getString("DESCRICAO"));
				evento.setData(rs.getDate("DATA"));
				evento.setResponsavel(rs.getString("RESPONSAVEL"));
				lista.add(evento);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return lista;
	}


}
