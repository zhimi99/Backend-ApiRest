package ups.edu.ec.iot.apirest.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ups.edu.ec.iot.apirest.model.dao.IClienteDao;
import ups.edu.ec.iot.apirest.modelo.entity.Cliente;


@Service
public class ClienteServicelmpl implements IClienteService {

	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll();
	}
	

	@Override
	@Transactional(readOnly = true)
	public Cliente findbyId(Long id) {
		
		return clienteDao.findById(id).orElse(null);
	}

	
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {

		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}
	
	
}
