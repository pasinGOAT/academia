public class Main {
    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();

        Aluno aluno = new Aluno("João", 25, 70.5, 1.75, "Mensal");
        dao.inserirAluno(aluno);
    }
}

