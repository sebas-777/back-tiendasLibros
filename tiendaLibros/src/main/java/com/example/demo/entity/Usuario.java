package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class Usuario {

   public Usuario(){

  }
  
  public Usuario(String username, String password,Rol role, Date fecha_expiracion) {
    this.setFecha_expiracion(fecha_expiracion);
    this.setPassword(password);
    this.setRole(role);
    this.setUsername(username);
  }

  @OneToOne
  @JoinColumn(name="role")
  private Rol rol;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "usuario",length = 20,nullable = false,unique = true)
  private String username;
  @Column(name = "contrasena",length = 20,nullable = false,unique = true)
  private String password;
 // @Column(name = "id_role",nullable = false,unique = false)
  //private Integer idrole;
  @Column(name = "expirationa_date",nullable = true,unique = false)
  private Date fecha_expiracion; 
  
  
  @OneToOne
  @JoinColumn(name = "id_role", referencedColumnName = "id",nullable = false)
  private Rol role;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Rol getRole() {
    return this.role;
  }

  public void setRole(Rol role) {
    this.role = role;
  }

  public Date getFecha_expiracion() {
    return fecha_expiracion;
  }

  public void setFecha_expiracion(Date fecha_expiracion) {
    this.fecha_expiracion = fecha_expiracion;
  } 
  @Override
  public String toString() {
    return "Usuario [fecha_expiracion=" + fecha_expiracion + ", id=" + id + ", role=" + this.role.getId() + ", username=" + username
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
