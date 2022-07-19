package ups.edu.ec.iot.apirest.model.dao;


import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.iot.apirest.modelo.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);//String email
	
	//@Query("select u from usuarios u where u.username=?1")
	//public Usuario findByUsername2(String userName);

}
