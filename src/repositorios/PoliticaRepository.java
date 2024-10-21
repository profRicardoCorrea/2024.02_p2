package repositorios;

import java.util.ArrayList;

import entidades.PoliticaAntirracista;
import util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import entidades.PoliticaAntirracista;
import insterfaces.IPoliticaRepository;

public class PoliticaRepository implements IPoliticaRepository {

	private Connection conn;
	public PoliticaRepository()  {
		try {
			this.conn = this.conn = ConnectionSingleton.getInstance().conexao;			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao fazer conexão"+e);
		}		
	}	

    @Override
    public void salvar(PoliticaAntirracista politica) {
        String sql = "INSERT INTO politicas_antirracistas (nome, descricao, ano_implementacao, efetividade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, politica.getNome());
            stmt.setString(2, politica.getDescricao());
            stmt.setInt(3, politica.getAnoImplementacao());
            stmt.setInt(4, politica.getEfetividade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PoliticaAntirracista> listarTodas() {
        String sql = "SELECT * FROM politicas_antirracistas";
        ArrayList<PoliticaAntirracista> politicas = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PoliticaAntirracista politica = new PoliticaAntirracista(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("ano_implementacao"),
                        rs.getInt("efetividade"));
                politicas.add(politica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return politicas;
    }

    @Override
    public PoliticaAntirracista buscarPorNome(PoliticaAntirracista politica) {
        String sql = "SELECT * FROM politicas_antirracistas WHERE nome = ?";
        PoliticaAntirracista resultado = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, politica.getNome());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                resultado = new PoliticaAntirracista(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("ano_implementacao"),
                        rs.getInt("efetividade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void remover(PoliticaAntirracista politica) {
        String sql = "DELETE FROM politicas_antirracistas WHERE nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, politica.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
