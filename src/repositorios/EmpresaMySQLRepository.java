package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
import entidades.Empresa;
import entidades.enums.TipoEmpresa;
import insterfaces.IEmpresaRepository;
 
import util.ConnectionFactory;
import util.ConnectionSingleton;

public class EmpresaMySQLRepository implements  IEmpresaRepository {
	
	private Connection conn;
	public EmpresaMySQLRepository()  {
		try {
			this.conn = this.conn = ConnectionSingleton.getInstance().conexao;			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	@Override
	public void salvar(Empresa empresa) throws SQLException   {

		try {			 
			 
			String sql = "INSERT INTO empresa( nome,endereco,anoFundacao,tipo) VALUES(?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, empresa.getNome());	
			ps.setString(2, empresa.getEndereco());
			ps.setInt(3, empresa.getCodigo());
			ps.setString(4, empresa.getTipo().getDescricao());
			 
			 
			int retorno = ps.executeUpdate();
			System.out.println("AQUIsalvo");
			if (retorno == 0) {
				throw new SQLException("Persistencia do Empresa falhou , ID do Empresa n�o foi gerado.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					//return generatedKeys.getLong(1);
					
				} else {
					throw new SQLException("Persistencia do EMPRESA  falhou , ID do Empresa n�o foi gerado.");
				}
			}
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Persistencia do EMPRESA falhou.");
		}

	}

	@Override
	public void alterar(Empresa empresa) throws SQLException {
		try {			 
			 
			String sqlEleitor = "UPDATE Empresa SET nome=?,idAtleta=?,dataNascimento=? Where idEmpresa=?;";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor);
			ps.setString(1, empresa.getNome());
			/*ps.setString(2, empresa.getNome());
			ps.setInt(2, empresa.getTecnico().getCodigo());			 
			ps.setDate(3, new java.sql.Date(Empresa.getDataNascimento().getEmpresa()));
			ps.setInt(4, Empresa.getCodigo());*/
			System.out.println(">>ALTERAR:"+empresa.getNome());
			int retorno = ps.executeUpdate();
			 
			if (retorno == 0) {
				throw new SQLException("Alteracao do EMPRESA falhou");
			}			 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Alteracao do EMPRESA falhou");
		}

	}

	 

	@Override
	public ArrayList<Empresa> listarTodos() throws SQLException {
		String sql="SELECT  idempresa,nome,endereco,anoFundacao,tipo  FROM Empresa;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();

		ArrayList<Empresa> Empresas=new ArrayList<Empresa>();
		while(rs.next()){
			try {
				Empresa e=new Empresa();
				e.setCodigo(rs.getInt("idEmpresa"));
				e.setNome(rs.getString("nome"));
				e.setAnoFundacao(rs.getInt("anoFundacao"));
				e.setTipo(TipoEmpresa.getEnum(rs.getString("tipo")));
				e.setEndereco(rs.getString("endereco"));
				
				 
				  
				Empresas.add(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				 
			}			 
			 	 
		}
		return Empresas;
	}

	@Override
	public void excluir(Empresa Empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa listarPorCodigo(int condigo) throws SQLException {
		String sql="SELECT  idempresa,nome,endereco,anoFundacao,tipo FROM Empresa Where idEmpresa=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, condigo);
		ResultSet rs = ps.executeQuery();
		rs.next(); 
		 
		Empresa e=new Empresa();
		e.setCodigo(rs.getInt("idEmpresa"));
		e.setNome(rs.getString("nome"));			
		e.setAnoFundacao(rs.getInt("anoFundacao"));
		e.setEndereco(rs.getString("endereco"));
		e.setTipo(TipoEmpresa.getEnum(rs.getString("tipo")));			 
		return e;
	}

	@Override
	public ArrayList<Empresa> persquisarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Empresa> persquisarTipo() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 

}
