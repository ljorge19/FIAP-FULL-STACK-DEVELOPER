package br.com.fiap.dao;





import java.util.HashSet;
import java.util.Set;

import br.com.fiap.entity.Escola;




public class DaoEscolaJDBC extends DaoJDBC<Escola> {

	@Override
	public void incluir(Escola elemento) throws Exception{
		try {
			abrirConexao();
			String sql = " INSERT INTO"
					   + " ESCOLA (ID, NOME,ENDEREÇO"
					   + " ) VALUES (?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setLong(1,  elemento.getId());
			stmt.setString(2, elemento.getNome());
			stmt.setString(3, elemento.getEndereço());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
	}

	
	@Override
	public void update(Escola elemento) throws Exception{
		try {
			abrirConexao();
			String sql = " update"
					   + " ESCOLA  set NOME = ?,ENDEREÇO = ?"
					   + "where id=?";
			stmt = cn.prepareStatement(sql);
			stmt.setLong(3,  elemento.getId());
			stmt.setString(1, elemento.getNome());
			stmt.setString(2, elemento.getEndereço());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
	}
	@Override
	public Escola buscar(Long id) throws Exception {
		
			Escola escola = null;
			
			try {
				abrirConexao();
				stmt = cn.prepareStatement("SELECT * FROM ESCOLA WHERE ID=?");
				stmt.setLong(1, id);
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					escola = new Escola();
					escola.setId(rs.getLong("ID"));
					escola.setEndereço(rs.getString("ENDEREÇO"));
					escola.setNome(rs.getString("NOME"));
					
				}
				
			} catch (Exception e) {
				throw e;
			} finally {
				fecharConexao();
			}
		return escola;
	}

	@Override
	public Set<Escola> listar(int... param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

