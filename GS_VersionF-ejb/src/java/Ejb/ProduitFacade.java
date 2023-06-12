/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entities.Marque;
import Entities.Produit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jeremie
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "GS_VersionF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }

    @Override
    public java.util.List findAllByMarque(String marque) {
        Query query = em.createQuery("select p from Produit p where p.marqueProduit.marque =:marque").setParameter("marque", marque);
        java.util.List produits = query.getResultList() ;
        return produits;
    }
    
    @Override
    public Boolean creerProduit(String refProduit, Marque marqueProduit, String denomination, float prix, float poids, float volume) {
        Produit produit = (Produit) em.find(Produit.class, refProduit);
        
        if(produit == null){
            produit = new Produit(refProduit,marqueProduit,denomination,prix,poids,volume);
            em.persist(produit);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Boolean supprimerProduit(String refProduit) {
        Produit produit = (Produit) em.find(Produit.class, refProduit);
        if(produit == null){
            return false;
        }
        else{
            remove(produit);
            return true;
        }
    }

    @Override
    public Boolean modifierProduit(String refProduit, String marqueProduit, String denomination, float prix, float poids, float volume) {
        Produit produit = (Produit) em.find(Produit.class, refProduit);
        Marque marque = (Marque) em.find(Marque.class, marqueProduit);
        if(produit == null){
            return false;
        }
        else{
            em.createQuery("update Produit p set p.marqueProduit=:marque, p.denomination=:denomination, p.prix=:prix, p.poids=:poids, p.volume=:volume where p.refProduit =:refProduit").setParameter("marque", marque).setParameter("denomination", denomination).setParameter("prix", prix).setParameter("poids", poids).setParameter("volume", volume).setParameter("refProduit", refProduit).executeUpdate();
            return true;
        }
    }
}
