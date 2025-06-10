import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

  Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        System.out.println("=== LOGIN ===");
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuarioLogado = dao.buscarPorLogin(login);

        if (usuarioLogado != null && usuarioLogado.getSenha().equals(senha)) {
            System.out.println("Bem-vindo, " + usuarioLogado.getCargo());

            if (usuarioLogado.getCargo().equals("admin")) {
                int opcao;
                do {
                    System.out.println("\nPainel do ADMIN");
                    System.out.println("1 - Cadastrar novo usuário");
                    System.out.println("2 - Excluir usuário");
                    System.out.println("3 - Sair");
                    System.out.print("Escolha: ");
                    opcao = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    switch (opcao) {
                        case 1:
                            System.out.print("Login do novo usuário: ");
                            String novoLogin = sc.nextLine();

                            System.out.print("Senha: ");
                            String novaSenha = sc.nextLine();

                            System.out.print("Cargo (admin, funcionario, membro): ");
                            String novoCargo = sc.nextLine();

                            Usuario novoUsuario = new Usuario(novoLogin, novaSenha, novoCargo);
                            dao.cadastrarUsuario(novoUsuario);
                            break;

                        case 2:
                            System.out.print("Login do usuário a ser removido: ");
                            String loginExcluir = sc.nextLine();
                            dao.excluirUsuario(loginExcluir);
                            break;

                        case 3:
                            System.out.println("Saindo do painel...");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcao != 3);
            } else {
                System.out.println("Você está logado como: " + usuarioLogado.getCargo());
            }

        } else {
            System.out.println("Login ou senha inválidos.");
        }
        
      if (usuarioLogado.getCargo().equals("membro")) {
                int opcao; 
                System.out.println("\n=== Painel do Membro (Treinos) ===");
                System.out.println("1 - Segunda");
                System.out.println("2 - Terça");
                System.out.println("3 - Quarta");
                System.out.println("4 - Quinta");
                System.out.println("5 - Sexta");
                System.out.println("6 - Sábado");
                System.out.println("7 - Domingo");
                System.out.println("8 - Sair");
                do {
                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    switch (opcao) {
                        case 1:
                            System.out.println("Segunda-feira: Treino de força e resistência.");
                            break;
                        case 2:
                            System.out.println("Terça-feira: Cardio e alongamento.");
                            break;
                        case 3:
                            System.out.println("Quarta-feira: Treino funcional.");
                            break;
                        case 4:
                            System.out.println("Quinta-feira: Yoga e pilates.");
                            break;
                        case 5:
                            System.out.println("Sexta-feira: Treino de alta intensidade.");
                            break;
                        case 6:
                            System.out.println("Sábado: Atividades ao ar livre.");
                            break;
                        case 7:
                            System.out.println("Domingo: Descanso e recuperação.");
                            break;
                        case 8:
                            System.out.println("Saindo do painel...");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (opcao != 8);
                
              


        Scanner read = new Scanner(System.in);
        Connection conn = Conexao.conectar();

   

        AlunoDAO alunoDAO = new AlunoDAO();

        while (true) {
            System.out.println("BEM-VINDO AO SISTEMA DE ACADEMIA");
            System.out.println("ESCOLHA SEU MÉTODO DESEJADO:");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Exibir Informações");
            System.out.println("3 - Excluir Aluno");
            System.out.println("4 - Sair");
            int op = read.nextInt();
            read.nextLine();

            if (op == 4) {
                System.out.println("Encerrando Programa...");
                break;
            }

            switch (op) {
                case 1:
                    System.out.println("=== Cadastro de Alunos ===");
                    System.out.print("Nome: ");
                    String nome = read.nextLine();

                    System.out.print("Idade: ");
                    int idade = read.nextInt();

                    System.out.print("Peso: ");
                    double peso = read.nextDouble();

                    System.out.print("Altura: ");
                    double altura = read.nextDouble();
                    read.nextLine(); // limpa o buffer

                    System.out.println("Selecione o plano:");
                    System.out.println("--> Mensal");
                    System.out.println("--> Trimestral");
                    System.out.println("--> Semestral");
                    System.out.println("--> Anual");
                    String plano = read.nextLine();

                    Aluno novoAluno = new Aluno(nome, idade, peso, altura, plano);
                    alunoDAO.inserirAluno(novoAluno); // <- grava no banco

                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("=== Exibir Informações ===");
                    List<Aluno> alunos = alunoDAO.listarAlunos();

                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado no banco.");
                    } else {
                        for (Aluno a : alunos) {
                            System.out.println("ID: " + a.getId());
                            System.out.println("Nome: " + a.getNome());
                            System.out.println("Idade: " + a.getIdade());
                            System.out.println("Peso: " + a.getPeso());
                            System.out.println("Altura: " + a.getAltura());
                            System.out.println("Plano: " + a.getPlano());
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("=== Excluir Aluno ===");
                    System.out.print("Digite o nome do aluno a ser excluído: ");
                    String nomeExcluir = read.nextLine();

                    alunoDAO.excluirAluno(nomeExcluir);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        read.close();
    }
}
}