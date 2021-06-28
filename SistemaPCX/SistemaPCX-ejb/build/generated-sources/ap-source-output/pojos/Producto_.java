package pojos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pojos.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T22:42:44")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Integer> codProducto;
    public static volatile SingularAttribute<Producto, Integer> precioUnitario;
    public static volatile ListAttribute<Producto, Venta> ventaCollection;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}