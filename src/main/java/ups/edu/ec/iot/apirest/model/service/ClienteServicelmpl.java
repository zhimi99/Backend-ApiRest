package ups.edu.ec.iot.apirest.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ups.edu.ec.iot.apirest.model.dao.IClienteDao;
import ups.edu.ec.iot.apirest.modelo.entity.Cliente;
import ups.edu.ec.iot.apirest.modelo.entity.Region;


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
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
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


	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
	
		return clienteDao.findAllRegiones();
	}
	
}
