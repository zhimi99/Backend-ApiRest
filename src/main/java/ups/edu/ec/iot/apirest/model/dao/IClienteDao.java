package ups.edu.ec.iot.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;

import ups.edu.ec.iot.apirest.modelo.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
