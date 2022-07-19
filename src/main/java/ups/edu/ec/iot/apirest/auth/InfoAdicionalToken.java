package ups.edu.ec.iot.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import ups.edu.ec.iot.apirest.model.service.IUsuarioService;
import ups.edu.ec.iot.apirest.modelo.entity.Usuario;


@Component
public class InfoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	 

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName()); 
		
		Map<String, Object> info = new HashMap<>();
		
		info.put("info adicional","hola que tal: ".concat(authentication.getName()));
		 
		info.put("Nombre_user", usuario.getNombre());
		info.put("Apellido_user", usuario.getApellido());
		info.put("Mail_user", usuario.getMail()); 
		
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
