package ups.edu.ec.iot.apirest.model.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ups.edu.ec.iot.apirest.modelo.entity.Cliente;
import ups.edu.ec.iot.apirest.modelo.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	@Query("from Region")
	public List<Region> findAllRegiones(); 
}
