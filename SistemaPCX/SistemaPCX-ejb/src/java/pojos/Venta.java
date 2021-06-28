/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCodVenta", query = "SELECT v FROM Venta v WHERE v.codVenta = :codVenta")
    , @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Venta.findBySubTotal", query = "SELECT v FROM Venta v WHERE v.subTotal = :subTotal")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codVenta")
    private Integer codVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subTotal")
    private int subTotal;
    @JoinColumn(name = "Cliente_codCli", referencedColumnName = "codCli")
    @ManyToOne(optional = false)
    private Cliente clientecodCli;
    @JoinColumn(name = "Producto_codProducto", referencedColumnName = "codProducto")
    @ManyToOne(optional = false)
    private Producto productocodProducto;
    @JoinColumn(name = "Vendedor_codVend", referencedColumnName = "codVend")
    @ManyToOne(optional = false)
    private Vendedor vendedorcodVend;

    public Venta() {
    }

    public Venta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public Venta(Integer codVenta, int cantidad, int subTotal) {
        this.codVenta = codVenta;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
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

    public Cliente getClientecodCli() {
        return clientecodCli;
    }

    public void setClientecodCli(Cliente clientecodCli) {
        this.clientecodCli = clientecodCli;
    }

    public Producto getProductocodProducto() {
        return productocodProducto;
    }

    public void setProductocodProducto(Producto productocodProducto) {
        this.productocodProducto = productocodProducto;
    }

    public Vendedor getVendedorcodVend() {
        return vendedorcodVend;
    }

    public void setVendedorcodVend(Vendedor vendedorcodVend) {
        this.vendedorcodVend = vendedorcodVend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVenta != null ? codVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codVenta == null && other.codVenta != null) || (this.codVenta != null && !this.codVenta.equals(other.codVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Venta[ codVenta=" + codVenta + " ]";
    }
    
}
