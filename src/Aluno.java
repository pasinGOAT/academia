public class Aluno {
   
    private int id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String plano;
    private String login;
    private String senha;
    // Construtor com ID, usado para exibição de informações
    public Aluno(int id, String nome, int idade, double peso, double altura, String plano, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.login = login;
        this.senha = senha;
    }
    // Construtor sem ID, usado para cadastro
    public Aluno(String nome, int idade, double peso, double altura, String plano, String login, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.login = login;
        this.senha = senha; 
    }

    

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
    
    public void ExibirFicha() {
        System.out.println("===Ficha do Aluno===");
        System.out.println("Nome: " + nome);
        System.out.println("Altura: " + altura);
        System.out.println("peso: " + peso);
        System.out.println("Idade: " + idade);
        System.out.println("Plano: " + plano);
    }
    
}


