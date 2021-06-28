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
import pojos.Cliente;
import service.ClienteFacadeLocal;

/**
 *
 * @author Joshua
 */
@Named(value = "clienteBean")
@RequestScoped
public class clienteBean {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    /**
     * Creates a new instance of clienteBean
     */
    
    private int codCli;
    private String nombreCli;
    private String correoCli;
    private int telefonoCli;
    
    
    private Cliente cliente;

    private List<Cliente> listCliente;

    @PostConstruct
    public void init() {
        listCliente = clienteFacade.findAll();
    }

    public List<Cliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }

    public clienteBean() {
        cliente = new Cliente();
    }
    
    public List<Cliente> getClientes(){
        return clienteFacade.findAll();
    }
    
    public String crear(){
        Cliente c = new Cliente();
        c.setCodCli(codCli);
        c.setNombreCli(nombreCli);
        c.setCorreoCli(correoCli);
        c.setTelefonoCli(telefonoCli);
        
        clienteFacade.create(c);
        
        return "cliente";
    }
    
     public String actualizar() {
        Cliente c = clienteFacade.find(cliente.getCodCli());
        c.setNombreCli(cliente.getNombreCli());
        c.setCorreoCli(cliente.getCorreoCli());
        c.setTelefonoCli(cliente.getTelefonoCli());
        clienteFacade.edit(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CLIENTE EDITADO"));
        return "index";
    }

    public String eliminar() {
        Cliente c = clienteFacade.find(cliente.getCodCli());
        clienteFacade.remove(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CLIENTE ELIMINADO"));
        return "index";
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getCorreoCli() {
        return correoCli;
    }

    public void setCorreoCli(String correoCli) {
        this.correoCli = correoCli;
    }

    public int getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(int telefonoCli) {
        this.telefonoCli = telefonoCli;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
