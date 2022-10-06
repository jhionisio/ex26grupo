package Service;

import java.sql.ResultSet;
import DAO.Dao;
import Model.Cliente;

public class ClienteService {
	
	public static void InserirCliente(Cliente c) { 
		String query = String.format("select max(id_cliente) as id_cliente from tb_cliente");
		ResultSet rs = Dao.SelectCommand(query);
		 try {
			 int id = -1;
	         while(rs.next()){
	             id = rs.getInt("id_cliente");
	         }
	                    
	         id++;

	         query=String.format("insert into tb_cliente(id_cliente, nome, idade, email, id_conta) values (%s,'%s','%s',%s,%s)", id, c.getNome(),c.getIdade(), c.getEmail(),id);
	         Dao.InsertUpdateDeleteCommand(query);
		} catch (Exception e) { 
            System.out.println(e);
         }
    }
   
    public static void AtualizarCliente(Cliente c) {
        String query = String.format("update tb_cliente set nome = '%s', set idade = %s, set email = '%s' where id = %s", c.getNome(), c.getIdade(), c.getEmail(), c.getId());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirCliente(int id) {
        String query = String.format("delete from tb_cliente where id = %s", id);
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExibirClientes() {
        String query= "select * from tb_cliente";
       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getString("idade"));
                System.out.println("Email: " + rs.getString("email"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
    }
   
    public static void ExibirCliente(int id) {
        String query = String.format("select * from tb_usuario where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	System.out.println("Id: " + rs.getString("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getString("idade"));
                System.out.println("Email: " + rs.getString("email"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}


