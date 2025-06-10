public class Func {
    String id;
    String nome;
    String cargo;
    double salario;
    String turno;

    // Construtor com ID, usado para consultas
    public Func(String id, String nome, String cargo, double salario, String turno) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
    }
    public Func(String nome, String cargo, double salario, String turno) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
    }

    // Getters e Setters
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
}
