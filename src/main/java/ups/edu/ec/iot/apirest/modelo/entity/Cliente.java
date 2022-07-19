package ups.edu.ec.iot.apirest.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "puede estar vacio")
	@Size(min=4, max=12, message = "el tamaño puede etsar entre 4 y 12 letras")
	@Column(nullable = false)
	private String nombre;
	
	@NotEmpty(message = "puede estar vacio")
	@Column(nullable = false)
	private String apellido;
	
	@NotEmpty(message = "No puede estar vacio")
	@Email(message = "correo invalido, necesita un formato valido")
	//@Column(nullable = false, unique = true)
	private String email;
	
	@NotNull(message = "No puede estar vacio fecha") 
	@Column(name="create_at") 
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	//@Column(name="foto")
	private String foto;  
	
	
	//@NotNull(message = "La region no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id") 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;
	
	
	/*
	 * @PrePersist public void prepersist() { this.createAt = new Date(); }
	 */
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	
}
