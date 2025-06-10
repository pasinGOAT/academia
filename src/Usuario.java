public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String cargo;

    public Usuario(String login, String senha, String cargo) {
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    // Getters e setters
    public int getId() { return id; }
    
    public void setId(int id) { this.id = id; }

    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getCargo() { return cargo; }
}
