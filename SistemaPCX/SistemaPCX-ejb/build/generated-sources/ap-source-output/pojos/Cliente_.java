package pojos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pojos.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T22:42:44")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> correoCli;
    public static volatile SingularAttribute<Cliente, Integer> codCli;
    public static volatile ListAttribute<Cliente, Venta> ventaCollection;
    public static volatile SingularAttribute<Cliente, String> nombreCli;
    public static volatile SingularAttribute<Cliente, Integer> telefonoCli;

}