package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;

public class ProdutoDAO {
    public static boolean inserir(Produto produto) {
        String sql = "INSERT INTO produtos " + " (nome, preco, quantidade, codCategoria, perecivel)"
                + "VALUES ( "
                + " '" + produto.getNome() + "' , "
                + " " + produto.getPreco() + ", "
                + " " + produto.getQuantidade() + ", "
                + " " + produto.getCategoria().getCodigo() + ", "
                + " " + produto.isPerecivel() + " );";
        return Conexao.executar(sql);
    }
    
    public static boolean editar(Produto produto) {
        String sql = "UPDATE produtos SET "
                + " nome =  '" + produto.getNome() + "' , "
                + " preco = " + produto.getPreco() + ", "
                + " quantidade = " + produto.getQuantidade() + ", "
                + " codCategoria = " + produto.getCategoria().getCodigo() + " ," 
                + " perecivel = " + produto.isPerecivel() + " "
                + " WHERE codigo = " + produto.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static boolean excluir(Produto produto){
        String sql = "DELETE FROM produtos "
                + " WHERE codigo = " + produto.getCodigo();
                return Conexao.executar(sql);
    }
    
    public static List<Produto> getProduto(){
    List<Produto> lista = new ArrayList<>();
    String sql = "SELECT p.codigo , p.nome, p.quantidade,"
            + " p.preco, p.perecivel, c.codigo, c.nome "
            + " FROM produtos p "
            + " INNER JOIN categorias c ON p.codCategoria = c.codigo "
            + " ORDER BY p.nome";
    ResultSet rs = Conexao.consultar(sql);
    
    if (rs != null){
        try{            
            while (rs.next()){
                Produto pro = new Produto();
                pro.setCodigo(rs.getInt(1));
                pro.setNome(rs.getString(2));
                pro.setQuantidade(rs.getDouble(3));
                pro.setPreco(rs.getDouble(4));
                pro.setPerecivel(rs.getBoolean(5));
                
                Categoria cat = new Categoria();
                cat.setCodigo(rs.getInt(6));
                cat.setNome(rs.getString(7));
                
                pro.setCategoria(cat);
                
                lista.add(pro);
            }    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    return lista;
}
}
