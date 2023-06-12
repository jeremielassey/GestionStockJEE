package Entities;

import Entities.Marque;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-12T08:23:52")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Float> volume;
    public static volatile SingularAttribute<Produit, String> refProduit;
    public static volatile SingularAttribute<Produit, Float> prix;
    public static volatile SingularAttribute<Produit, Float> poids;
    public static volatile SingularAttribute<Produit, Marque> marqueProduit;
    public static volatile SingularAttribute<Produit, String> denomination;

}