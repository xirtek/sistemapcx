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
import service.VendedorFacadeLocal;

/**
 *
 * @author Joshua
 */
@Named(value = "vendedorBean")
@RequestScoped
public class vendedorBean {

    @EJB
    private VendedorFacadeLocal vendedorFacade;

    /**
     * Creates a new instance of vendedorBean
     */
    private int codVend;
    private String nomVend;
    private int telefonoVend;
     
    
    private Vendedor vendedor;
    
    private List<Vendedor> listVendedor;
    
    @PostConstruct
    public void init(){
        listVendedor = vendedorFacade.findAll();
    } 
     
    public vendedorBean() {
        vendedor = new Vendedor();
    }
    
    public List<Vendedor> getVendedores(){
        return vendedorFacade.findAll();
    }
    
    public List<Vendedor> getListVendedor() {
        return listVendedor;
    }

    public void setListVendedor(List<Vendedor> listVendedor) {
        this.listVendedor = listVendedor;
    }
    
    public String crear(){
        Vendedor v = new Vendedor();
        v.setCodVend(codVend);
        v.setNomVend(nomVend);
        v.setTelefonoVend(telefonoVend);
        
        vendedorFacade.create(v);
        
        return "vendedor";
    }
    
    public String actualizar()
    {
        Vendedor v = vendedorFacade.find(vendedor.getCodVend());
        v.setNomVend(vendedor.getNomVend());
        v.setTelefonoVend(vendedor.getTelefonoVend());
        vendedorFacade.edit(v);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("VENDEDOR EDITADO"));
        return "index";
    }
    
    public String eliminar()
    {
        Vendedor v = vendedorFacade.find(vendedor.getCodVend());
        vendedorFacade.remove(v);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("VENDEDOR ELIMINADO"));
        return "index";
    }

    public int getCodVend() {
        return codVend;
    }

    public void setCodVend(int codVend) {
        this.codVend = codVend;
    }

    public String getNomVend() {
        return nomVend;
    }

    public void setNomVend(String nomVend) {
        this.nomVend = nomVend;
    }

    public int getTelefonoVend() {
        return telefonoVend;
    }

    public void setTelefonoVend(int telefonoVend) {
        this.telefonoVend = telefonoVend;
    }
    
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
    
}
