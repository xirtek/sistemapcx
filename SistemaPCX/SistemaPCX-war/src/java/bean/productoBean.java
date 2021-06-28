/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.*;
import service.ProductoFacadeLocal;

/**
 *
 * @author Joshua
 */
@Named(value = "productoBean")
@RequestScoped
public class productoBean {

    @EJB
    private ProductoFacadeLocal productoFacade;

    /**
     * Creates a new instance of productoBean
     */
    
    private int codProducto;
    private String nombreProducto;
    private int stock;
    private int precioUnitario;
    

    private Producto producto;
    
    private List<Producto> listProducto;
    
    @PostConstruct
    public void init(){
        listProducto = productoFacade.findAll();
    } 
    
    public productoBean() {
        producto = new Producto();
    }
    
    public List<Producto> getProductos(){
        return productoFacade.findAll();
    }
    
    
    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }
    
    public String crear(){
        Producto p = new Producto();
        p.setCodProducto(codProducto);
        p.setNombreProducto(nombreProducto);
        p.setStock(stock);
        p.setPrecioUnitario(precioUnitario);
        productoFacade.create(p);
        
        return "producto";
    }
    
    public String actualizar()
    {
        Producto p = productoFacade.find(producto.getCodProducto());
        p.setNombreProducto(producto.getNombreProducto());
        p.setStock(producto.getStock());
        p.setPrecioUnitario(producto.getPrecioUnitario());
        productoFacade.edit(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PRODUCTO EDITADO"));
        return "index";
    }
    
    public String eliminar()
    {
        Producto p = productoFacade.find(producto.getCodProducto());
        productoFacade.remove(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PRODUCTO ELIMINADO"));
        return "index";
    }
    

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
