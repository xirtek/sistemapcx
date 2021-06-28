/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import pojos.*;
import service.ClienteFacadeLocal;
import service.ProductoFacadeLocal;
import service.VendedorFacadeLocal;
import service.VentaFacadeLocal;

/**
 *
 * @author Joshua
 */
@Named(value = "ventaBean")
@RequestScoped

public class ventaBean {

    @EJB
    private VentaFacadeLocal ventaFacade;

    @EJB
    private VendedorFacadeLocal vendedorFacade;

    @EJB
    private ProductoFacadeLocal productoFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    /**
     * Creates a new instance of ventaBean
     */
    private int codVenta;
    private int cantidad;
    private int subTotal;

    //weas foraneas
    private Cliente cliente;
    private Producto producto;
    private Vendedor vendedor;
    private Venta venta;

    public ventaBean() {
        // aqui van las relaciones 
        cliente = new Cliente();
        producto = new Producto();
        vendedor = new Vendedor();
    }

    public List<Venta> getVentas() {
        return ventaFacade.findAll();
    }

    public String crear() {
        Venta ve = new Venta();

        //tener precio unitario
        Producto pro1 = new Producto();
        pro1 = productoFacade.find(producto.getCodProducto());

        ve.setCodVenta(codVenta);
        ve.setCantidad(cantidad);
        ve.setSubTotal(cantidad * pro1.getPrecioUnitario());

        ve.setClientecodCli(clienteFacade.find(cliente.getCodCli()));
        ve.setProductocodProducto(productoFacade.find(producto.getCodProducto()));
        ve.setVendedorcodVend(vendedorFacade.find(vendedor.getCodVend()));

        ventaFacade.create(ve);

        return "venta";
    }

    
    public String eliminar() {
        Venta ve = new Venta();
        ve = ventaFacade.find(venta.getCodVenta());
        ventaFacade.remove(ve);

        return "venta";
    }

    //finalizar compra y limpiar tabla
    public String finalizarVenta() {

        for (Venta ventita : getVentas()) {
            ventaFacade.remove(ventita);
        }

        return "venta";
    }

    public VentaFacadeLocal getVentaFacade() {
        return ventaFacade;
    }

    public void setVentaFacade(VentaFacadeLocal ventaFacade) {
        this.ventaFacade = ventaFacade;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int total() {
        int totalito = 0;
        for (Venta ventita : getVentas()) {
            totalito += ventita.getSubTotal();
        }
        return totalito;
    }

}
