import java.sql.*;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (login, senha, cargo) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getCargo());

            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public Usuario buscarPorLogin(String login) {
        String sql = "SELECT * FROM usuarios WHERE login = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario(
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("cargo")
                );
                u.setId(rs.getInt("id"));
                return u;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }

        return null;
    }

    public void excluirUsuario(String login) {
        String sql = "DELETE FROM usuarios WHERE login = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Usuário não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }
}
