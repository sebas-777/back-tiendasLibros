package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="categories")
public class Categoria{

  public Categoria(){

  }

  public Categoria(String nombre, String descripcion) {
    this.setDescripcion(descripcion);
    this.setNombre(nombre);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 20, name = "name", nullable = false, unique = true)
  private String nombre;
  @Column(length = 50, name = "description", nullable = true, unique = false)
  private String descripcion;
  
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
  private List<Producto> products;
  
  public List<Producto> getProducts(){
	  return products;
  }
  
  public boolean addProduct(Producto product){
	  if (products == null) {
		products = new ArrayList<>();
	} 
	  return this.products.add(product);
  }


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
    return "categoria [descripcion=" + descripcion + ", id=" + id + ", nombre=" + nombre + "]";
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
    Categoria other = (Categoria) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
