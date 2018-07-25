package model;

public class Categoria {
    private int codigo;
    private String nome;

    public Categoria() {

    }

    public Categoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getNome(){
        return this.nome;        
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
