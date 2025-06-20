import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // INSERIR ALUNO
    public void inserirAluno(Aluno aluno) {
        Connection conn = Conexao.conectar();

        try {
            String sql = "INSERT INTO aluno (nome, idade, peso, altura, plano, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setDouble(3, aluno.getPeso());
            stmt.setDouble(4, aluno.getAltura());
            stmt.setString(5, aluno.getPlano());
            stmt.setString(6, aluno.getLogin());
            stmt.setString(7, aluno.getSenha());

            stmt.executeUpdate();
            conn.close();
            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
        }
    }

    // LISTAR ALUNOS 
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = Conexao.conectar();

        try {
            String sql = "SELECT * FROM aluno";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getDouble("peso"),
                    rs.getDouble("altura"),
                    rs.getString("plano"),
                    rs.getString("login"),
                    rs.getString("senha")
                );
                alunos.add(aluno);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar alunos: " + e.getMessage());
        }

        return alunos;
    }

    // EXCLUIR ALUNOS
    public void excluirAluno(int id) {
        Connection conn = Conexao.conectar();

        try {
            String sql = "DELETE FROM aluno WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            conn.close();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao  aluno: " + e.getMessage());
        }
    }
}

