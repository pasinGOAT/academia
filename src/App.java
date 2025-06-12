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
            AlunoDAO alunoDAO = new AlunoDAO();

            if (usuarioLogado.getCargo().equals("admin")) {
                int opcao;
                do {
                    System.out.println("\nPainel do ADMIN");
                    System.out.println("1 - Cadastrar novo usuário");
                    System.out.println("2 - Excluir usuário");
                    System.out.println("3 - Exibir Informações dos usuários");
                    System.out.println("4 - Sair");
                    System.out.print("Escolha: ");
                    opcao = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    switch (opcao) {
                        case 1:
                            System.out.print("Login do novo usuário: ");
                            String novoLogin = sc.nextLine();

                            System.out.print("Senha: ");
                            String novaSenha = sc.nextLine();

                            String novoCargo;
                            while (true) {
                                System.out.print("Cargo (admin, funcionario, membro): ");
                                novoCargo = sc.nextLine();
                                if (novoCargo.equals("admin") || novoCargo.equals("funcionario") || novoCargo.equals("membro")) {
                                    break;
                                }
                                System.out.println("Cargo inválido. Tente novamente.");
                            }

                            Usuario novoUsuario = new Usuario(novoLogin, novaSenha, novoCargo);
                            dao.cadastrarUsuario(novoUsuario);

                            System.out.println("=== Cadastro de Aluno ===");
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Idade: ");
                            int idade = sc.nextInt();
                            System.out.print("Peso: ");
                            double peso = sc.nextDouble();
                            System.out.print("Altura: ");
                            double altura = sc.nextDouble();
                            sc.nextLine(); // limpar buffer

                            System.out.println("Plano (Mensal, Trimestral, Semestral, Anual): ");
                            String plano = sc.nextLine();

                            Aluno novoAluno = new Aluno(nome, idade, peso, altura, plano, novoLogin, novaSenha);
                            alunoDAO.inserirAluno(novoAluno);
                            break;

                        case 2:
                            System.out.print("ID do usuário a ser removido: ");
                            int IDExcluir = sc.nextInt();
                            dao.excluirUsuario(IDExcluir);
                            break;

                        case 3:
                            List<Aluno> alunos = alunoDAO.listarAlunos();
                            if (alunos.isEmpty()) {
                                System.out.println("Nenhum aluno cadastrado.");
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

                        case 4:
                            System.out.println("Saindo do painel do admin...");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcao != 4);
            }

            else if (usuarioLogado.getCargo().equals("membro")) {
                int opcaoMembro;
                do {
                    System.out.println("\n=== Painel do Membro ===");
                    System.out.println("1 - Exibir ficha do aluno");
                    System.out.println("2 - Treinos");
                    System.out.println("3 - Sair");
                    System.out.print("Escolha uma opção: ");
                    opcaoMembro = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    switch (opcaoMembro) {
                        case 1:
                            AlunoDAO alunoDAO2 = new AlunoDAO();
                            List<Aluno> alunos = alunoDAO2.listarAlunos();
                            if (alunos.isEmpty()) {
                                System.out.println("Nenhum aluno cadastrado.");
                            } else {
                                for (Aluno a : alunos) {
                                    a.ExibirFicha();
                                }
                            }
                            break;

                        case 2:
                            int opcaoTreino;
                            do {
                                System.out.println("\n=== Painel do Membro (Treinos) ===");
                                System.out.println("1 - Segunda");
                                System.out.println("2 - Terça");
                                System.out.println("3 - Quarta");
                                System.out.println("4 - Quinta");
                                System.out.println("5 - Sexta");
                                System.out.println("6 - Sábado");
                                System.out.println("7 - Domingo");
                                System.out.println("8 - Sair");
                                System.out.print("Escolha uma opção: ");
                                opcaoTreino = sc.nextInt();

                                switch (opcaoTreino) {
                                    case 1 -> System.out.println("Segunda-feira: Treino de força e resistência.");
                                    case 2 -> System.out.println("Terça-feira: Cardio e alongamento.");
                                    case 3 -> System.out.println("Quarta-feira: Treino funcional.");
                                    case 4 -> System.out.println("Quinta-feira: Yoga e pilates.");
                                    case 5 -> System.out.println("Sexta-feira: Treino de alta intensidade.");
                                    case 6 -> System.out.println("Sábado: Atividades ao ar livre.");
                                    case 7 -> System.out.println("Domingo: Descanso e recuperação.");
                                    case 8 -> System.out.println("Saindo do painel de treinos...");
                                    default -> System.out.println("Opção inválida.");
                                }
                            } while (opcaoTreino != 8);
                            break;

                        case 3:
                            System.out.println("Saindo do painel...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcaoMembro != 3);
            }

        } else {
            System.out.println("Login ou senha inválidos.");
        }

        sc.close();
    }
}
