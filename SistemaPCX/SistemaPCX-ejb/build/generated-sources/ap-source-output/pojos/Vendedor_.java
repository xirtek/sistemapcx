package pojos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pojos.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T22:42:44")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, Integer> codVend;
    public static volatile SingularAttribute<Vendedor, String> nomVend;
    public static volatile SingularAttribute<Vendedor, Integer> telefonoVend;
    public static volatile ListAttribute<Vendedor, Venta> ventaCollection;

}