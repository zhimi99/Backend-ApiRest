package ups.edu.ec.iot.apirest.model.service;

import ups.edu.ec.iot.apirest.modelo.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
