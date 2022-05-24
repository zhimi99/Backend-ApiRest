package ups.edu.ec.iot.apirest.model.service;

import java.util.List;
import ups.edu.ec.iot.apirest.modelo.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findbyId(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);

}
