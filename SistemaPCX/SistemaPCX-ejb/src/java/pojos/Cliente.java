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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodCli", query = "SELECT c FROM Cliente c WHERE c.codCli = :codCli")
    , @NamedQuery(name = "Cliente.findByNombreCli", query = "SELECT c FROM Cliente c WHERE c.nombreCli = :nombreCli")
    , @NamedQuery(name = "Cliente.findByCorreoCli", query = "SELECT c FROM Cliente c WHERE c.correoCli = :correoCli")
    , @NamedQuery(name = "Cliente.findByTelefonoCli", query = "SELECT c FROM Cliente c WHERE c.telefonoCli = :telefonoCli")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCli")
    private Integer codCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreCli")
    private String nombreCli;
    @Size(max = 40)
    @Column(name = "correoCli")
    private String correoCli;
    @Column(name = "telefonoCli")
    private Integer telefonoCli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientecodCli")
    private List<Venta> ventaCollection;

    public Cliente() {
    }

    public Cliente(Integer codCli) {
        this.codCli = codCli;
    }

    public Cliente(Integer codCli, String nombreCli) {
        this.codCli = codCli;
        this.nombreCli = nombreCli;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
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

    public Integer getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(Integer telefonoCli) {
        this.telefonoCli = telefonoCli;
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
        hash += (codCli != null ? codCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCli == null && other.codCli != null) || (this.codCli != null && !this.codCli.equals(other.codCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Cliente[ codCli=" + codCli + " ]";
    }
    
}
