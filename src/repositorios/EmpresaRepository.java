package repositorios;


import java.sql.*;
import java.util.ArrayList;
import entidades.Empresa;
import entidades.PoliticaAntirracista;
import entidades.enums.TipoEmpresa;
import insterfaces.IEmpresaRepository;
import util.ConnectionSingleton;

public class EmpresaRepository implements IEmpresaRepository {

    private Connection connection;

    public EmpresaRepository() {
    	try {
    		 this.connection = ConnectionSingleton.getInstance().conexao;			 			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    }

    @Override
    public void salvar(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO empresas (nome, endereco, ano_fundacao, tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEndereco());
            stmt.setInt(3, empresa.getAnoFundacao());
            stmt.setString(4, empresa.getTipo().toString());
            stmt.executeUpdate();
            
            // Salvar políticas associadas, se houver
            for (PoliticaAntirracista politica : empresa.getPoliticas()) {
                salvarPolitica(empresa.getNome(), politica);
            }
        }
    }

    private void salvarPolitica(String nomeEmpresa, PoliticaAntirracista politica) throws SQLException {
        String sql = "INSERT INTO politicas_empresa (nome_empresa, nome_politica) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nomeEmpresa);
            stmt.setString(2, politica.getNome());
            stmt.executeUpdate();
        }
    }

    @Override
    public void alterar(Empresa empresa) throws SQLException {
        String sql = "UPDATE empresas SET endereco = ?, ano_fundacao = ?, tipo = ? WHERE nome = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.getEndereco());
            stmt.setInt(2, empresa.getAnoFundacao());
            stmt.setString(3, empresa.getTipo().toString());
            stmt.setString(4, empresa.getNome());
            stmt.executeUpdate();

            // Atualizar políticas associadas
            removerPoliticas(empresa.getNome());
            for (PoliticaAntirracista politica : empresa.getPoliticas()) {
                salvarPolitica(empresa.getNome(), politica);
            }
        }
    }

    private void removerPoliticas(String nomeEmpresa) throws SQLException {
        String sql = "DELETE FROM politicas_empresa WHERE nome_empresa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nomeEmpresa);
            stmt.executeUpdate();
        }
    }

    @Override
    public Empresa listarPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT * FROM empresas WHERE id = ?";
        Empresa empresa = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                empresa = new Empresa(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getInt("ano_fundacao"),
                        TipoEmpresa.valueOf(rs.getString("tipo")));
                empresa.setPoliticas(listarPoliticas(rs.getString("nome")));
            }
        }
        return empresa;
    }

    private ArrayList<PoliticaAntirracista> listarPoliticas(String nomeEmpresa) throws SQLException {
        String sql = "SELECT * FROM politicas_empresa WHERE nome_empresa = ?";
        ArrayList<PoliticaAntirracista> politicas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nomeEmpresa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PoliticaAntirracista politica = new PoliticaAntirracista(
                        rs.getString("nome_politica"),
                        "Descrição placeholder", // Aqui você pode buscar a descrição da política em outra tabela
                        0, // Ano de implementação placeholder
                        0 // Efetividade placeholder
                );
                politicas.add(politica);
            }
        }
        return politicas;
    }

    @Override
    public ArrayList<Empresa> persquisarPorNome(String nome) {
        String sql = "SELECT * FROM empresas WHERE nome LIKE ?";
        ArrayList<Empresa> empresas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getInt("ano_fundacao"),
                        TipoEmpresa.valueOf(rs.getString("tipo")));
                empresa.setPoliticas(listarPoliticas(rs.getString("nome")));
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }

    @Override
    public ArrayList<Empresa> persquisarTipo() {
        String sql = "SELECT * FROM empresas WHERE tipo = ?";
        ArrayList<Empresa> empresas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Aqui você pode definir um tipo específico, se necessário, como um parâmetro
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getInt("ano_fundacao"),
                        TipoEmpresa.valueOf(rs.getString("tipo")));
                empresa.setPoliticas(listarPoliticas(rs.getString("nome")));
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }

    @Override
    public ArrayList<Empresa> listarTodos() throws SQLException {
        String sql = "SELECT * FROM empresas";
        ArrayList<Empresa> empresas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getInt("ano_fundacao"),
                        TipoEmpresa.valueOf(rs.getString("tipo")));
                empresa.setPoliticas(listarPoliticas(rs.getString("nome")));
                empresas.add(empresa);
            }
        }
        return empresas;
    }

    @Override
    public void excluir(Empresa empresa) {
        String sql = "DELETE FROM empresas WHERE nome = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNome());
            stmt.executeUpdate();
            removerPoliticas(empresa.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

