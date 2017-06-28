package vinil.model.DAO;

import vinil.model.Funcionario;
import java.sql.*;

public class FuncionarioDAO {

	Configurador config;
	
	public FuncionarioDAO()
	{
		config = new Configurador();
	}
	
	public int cadastrarFuncionario(Funcionario funcionario)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call inserirfuncionario( ?, ?, ?, ?, ?, ? ) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, funcionario.getNome());
	        cs.setString(3, funcionario.getCpf());
	        cs.setString(4, funcionario.getEmail());
	        cs.setString(5, funcionario.getSenha());
	        cs.setString(6, funcionario.getCargo());
	        
	        if (funcionario.getInicioGerencia() == null)
	        	cs.setNull(7, Types.NULL);
	        else
	        	cs.setString(7, funcionario.getInicioGerencia().toString());
	        
	        cs.execute();
	        int retornoFuncao = cs.getInt(1);
	        cs.close();
	        return retornoFuncao;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
		}
	}
	
	public int alterarSenha(int idFuncionario, String novaSenha)
	{
		return 0;
	}
	
}
