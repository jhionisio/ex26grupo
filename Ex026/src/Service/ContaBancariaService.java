package Service;

import java.sql.ResultSet;
import DAO.Dao;
import Model.ContaBancaria;

public class ContaBancariaService {
	
		public static void InserirContaBancaria(ContaBancaria c) {
			String query = String.format("select max(id_conta) as id_conta from tb_conta_bancaria");
			ResultSet rs = Dao.SelectCommand(query);
			 try {
				 int id = -1;
		         while(rs.next()){
		             id = rs.getInt("id_conta");
		         }
		                    
		         id++;
		         
		         query=String.format("insert into tb_conta_bancaria(id_conta, agencia, numero, saldo) values (%s,'%s','%s',%s)",id,c.getAgencia(),c.getNumero(), 0);
		         Dao.InsertUpdateDeleteCommand(query);
		         
			} catch (Exception e) { 
	            System.out.println(e);
			}
		}
		
		public static void ExcluirContaBancaria(int id) {
	        String query = String.format("delete from tb_conta_bancaria where ID_CONTA = %s", id);
	        Dao.InsertUpdateDeleteCommand(query); 
	    }
		
		public static void ExibirContaBancaria(int id) {
	        String queryConta=String.format("select * from tb_conta_bancaria where id_conta = %s", id); 
	        
	        ResultSet rs=Dao.SelectCommand(queryConta);
	        
	        try {
	            while(rs.next()){
	            	System.out.println("Id: " + rs.getString("id"));
	                System.out.println("Agência: " + rs.getString("agencia"));
	                System.out.println("Número: " + rs.getString("numero"));
	                System.out.println("Saldo: " + rs.getString("saldo"));
	            }
	        }
	        catch (Exception e){
	        	System.out.println(e);
	        }
		}  

}
