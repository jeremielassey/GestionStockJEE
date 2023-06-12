package Entities;

import Entities.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-12T08:23:52")
@StaticMetamodel(Marque.class)
public class Marque_ { 

    public static volatile SingularAttribute<Marque, String> origine;
    public static volatile ListAttribute<Marque, Produit> listeProduits;
    public static volatile SingularAttribute<Marque, String> marque;

}