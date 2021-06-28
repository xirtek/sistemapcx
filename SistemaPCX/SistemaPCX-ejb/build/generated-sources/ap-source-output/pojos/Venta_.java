package pojos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pojos.Cliente;
import pojos.Producto;
import pojos.Vendedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T22:42:44")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Cliente> clientecodCli;
    public static volatile SingularAttribute<Venta, Producto> productocodProducto;
    public static volatile SingularAttribute<Venta, Vendedor> vendedorcodVend;
    public static volatile SingularAttribute<Venta, Integer> cantidad;
    public static volatile SingularAttribute<Venta, Integer> subTotal;
    public static volatile SingularAttribute<Venta, Integer> codVenta;

}