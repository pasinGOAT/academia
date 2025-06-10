public class Aluno {
   
    private String id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String plano;

    // Construtor com ID, usado para exibição de informações
    public Aluno(String id, String nome, int idade, double peso, double altura, String plano) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
    }
    // Construtor sem ID, usado para cadastro
    public Aluno(String nome, int idade, double peso, double altura, String plano) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
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
