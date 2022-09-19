package com.example.demo.entity;

import javax.persistence.*;




@Entity
@Table(name="roles")
public class Rol {

  //Constructor
  public Rol(){

  }

  public Rol(String nombre, String descripcion) {
    this.setNombre(nombre);
    this.setDescripcion(descripcion);
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 20, name = "name", nullable = false, unique = true )
  private String nombre;
  @Column(length = 50, name = "description", nullable = true, unique = false )
  private String descripcion;

  //Relación de Muchos a uno
  // @OneToMany(mappedBy = "user",cascade= CascadeType.ALL)
  // private List<Usuario> usuarios;

  // public boolean addOrder(Order order){
  //   if(orders == null)
  //   orders = new ArrayList<>();
  //   return this.orders.add(order);

  // }
  //Get and Setter
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Rol [descripcion=" + descripcion + ", id=" + id + ", nombre=" + nombre + "]";
  }
  //HashCode
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
    Rol other = (Rol) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
