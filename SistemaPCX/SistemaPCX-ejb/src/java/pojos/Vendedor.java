/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByCodVend", query = "SELECT v FROM Vendedor v WHERE v.codVend = :codVend")
    , @NamedQuery(name = "Vendedor.findByNomVend", query = "SELECT v FROM Vendedor v WHERE v.nomVend = :nomVend")
    , @NamedQuery(name = "Vendedor.findByTelefonoVend", query = "SELECT v FROM Vendedor v WHERE v.telefonoVend = :telefonoVend")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codVend")
    private Integer codVend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nomVend")
    private String nomVend;
    @Column(name = "telefonoVend")
    private Integer telefonoVend;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorcodVend")
    private List<Venta> ventaCollection;

    public Vendedor() {
    }

    public Vendedor(Integer codVend) {
        this.codVend = codVend;
    }

    public Vendedor(Integer codVend, String nomVend) {
        this.codVend = codVend;
        this.nomVend = nomVend;
    }

    public Integer getCodVend() {
        return codVend;
    }

    public void setCodVend(Integer codVend) {
        this.codVend = codVend;
    }

    public String getNomVend() {
        return nomVend;
    }

    public void setNomVend(String nomVend) {
        this.nomVend = nomVend;
    }

    public Integer getTelefonoVend() {
        return telefonoVend;
    }

    public void setTelefonoVend(Integer telefonoVend) {
        this.telefonoVend = telefonoVend;
    }

    @XmlTransient
    public List<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(List<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVend != null ? codVend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codVend == null && other.codVend != null) || (this.codVend != null && !this.codVend.equals(other.codVend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Vendedor[ codVend=" + codVend + " ]";
    }
    
}
