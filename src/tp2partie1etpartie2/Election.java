
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2partie1etpartie2;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.Serializable;

/**
 * La classe Élection 
 * @author Romy Steve / Jean Acre
 * @version A2018
 */
public class Election implements Serializable{
    private int annee;
    private Vector<String> nomsCirconscriptions;
    private ArrayList<String> nomsParti;
    private LinkedList<String> nomsDepute;
    private LinkedList<Depute> listeDepute;
    private Vector<Circonscription> listeCirconscription;
    private int [][] index;
    private ArrayList<Parti> partis;
    
    //utile pour connaitre la categorie du parti à partir du noms du parti
    private ArrayList<String> nomsPartisGauche;
    //utile pour connaitre la categorie du parti à partir du noms du parti
    private ArrayList<String> nomsPartisDroite;
      //utile pour connaitre la categorie du parti à partir du noms du parti
    private ArrayList<String> nomsPartisCentre;
    
    public Election(int annee){
        nomsCirconscriptions = new Vector<String>();
        nomsParti = new ArrayList<String>();
        nomsDepute = new LinkedList<String>();
        listeDepute = new LinkedList<Depute>();
        listeCirconscription = new Vector<Circonscription>();
        index = new int[nomsCirconscriptions.size()][nomsParti.size()];
        partis = new ArrayList<Parti>();
           
        nomsPartisGauche = new ArrayList<String>();
        nomsPartisDroite = new ArrayList<String>();
        nomsPartisCentre = new ArrayList<String>();
           
    }
    
    public Election(){
           this(Constantes.ANNEE_ELECTION);
    }
    
   /**
    * accesseur qui permet d'accéder au tableau index
    * 
    * @return le  tableau index
    */
    public int[][] getIndex(){
         return this.index;
    }
    /**
     * accesseur de la liste nomsPartisDroite
     * @return nomsPartisDroite
     */
    public ArrayList<String> getNomsPartisGauche(){
        return nomsPartisGauche;
    }
    
     /**
     * accesseur de la liste nomsPartisDroite
     * @return nomsPartisDroite
     */
    public ArrayList<String> getNomsPartisDroite(){
        return nomsPartisDroite;
    }
    
     /**
     * accesseur de la liste nomsPartisDroite
     * @return nomsPartisDroite
     */
    public ArrayList<String> getNomsPartisCentre(){
        return nomsPartisCentre;
    }
    
     /**
     * accesseur de la liste nomsPartisDroite
     * @return nomsPartisDroite
     */
    public ArrayList<String> getNomsPartis(){
        return nomsParti;
    }
    
   
    
   /**
    * accesseur qui permet de modifier le tableau index
    * @param int [][] le nouveau tableau 
    * 
    */
    public void setIndex(int [][] tab){
          this.index = tab;
    }
    
   /**
    * méthode qui permet d'ajouter un nom de circonscrition dans la collection
    * nomsCirconscriptions et un object circonscription dans la collection des
    * objets circonscription
    * @param String  nom de circonscrition
    * @param int  numero de l'élu
    * @return la position où le nom est ajouté dans la collection
    */
    public int ajouterCirconscription(String nom, int numero){
        int pos;
         /**
         * stratégie: vérifier que le nom n'existe pas dans la collection et l'ajouter 
         *            à la collection et retenir sa position sinon retenir sa position
         */  
        
        if(!nomsCirconscriptions.contains(nom)){
            nomsCirconscriptions.add(nom);
            pos = this.creationObjCircons(nom, numero);
        }else{
            pos = nomsCirconscriptions.indexOf(nom);
        }
        return pos;
    }
    
   /**
    * méthode qui permet d'ajouter un nom de parti dans la collection
    * nomsParti 
    * @param String  nom de parti
    * @return la position où le nom est ajouté dans la collection
    */
    public int ajouterNomParti(String nomParti){
       /**
         * stratégie: vérifier que le nom n'existe pas dans la collection et l'ajouter 
         *            à la collection et retenir sa position sinon retenir sa position
         */   
        
        if(!nomsParti.contains(nomParti)){
            nomsParti.add(nomParti);
        }
        return nomsParti.indexOf(nomParti);
    }
    
    /**
    * méthode qui permet d'ajouter un nom du député dans la collection
    * nomsDepute et un object depute dans la collection des
    * objets députés
    * @param int  numero de sa circonscrition
    * @param String  nom du député
    * 
    */
    public void ajouterDepute(int circonscription, String nomDepute, int noParti){
        /**
         * stratégie: vérifier que le nom n'existe pas dans la collection et l'ajouter 
         *            à la collection et retenir sa position sinon retenir sa position
         */ 
        
        if(!nomsDepute.contains(nomDepute)){
            nomsDepute.add(nomDepute);
            this.creationObjDepute(circonscription, nomDepute, noParti);
        }
    }
    
    /**
    * Sous programme qui permet de créer un objet circonscription
    * @param String  nom de circonscrition
    * @param int  numero de l'élu
    * @return la position où le nom est ajouté dans la collection
    */
    private int creationObjCircons(String nom, int numero){
        
        Circonscription circons = new Circonscription();
        circons.setNomCircons(nom);
        circons.setNoCircons(numero);
        listeCirconscription.add(circons);
         
        return listeCirconscription.indexOf(circons);
    }
    
    /**
    * Sous programme qui permet de créer un objet Depute
    * @param int  numero de circonscrition du député
    * @param String  nom du député
    * @param int  numero de parti du député 
    * 
    */
    private void creationObjDepute(int noCirconsDep, String nomDep, int noPartiDep){
        Depute depute = new Depute(nomDep, noCirconsDep, noPartiDep);
        listeDepute.add(depute);
    }
    
    /**
    * Méthode qui permet de transformer la collection nomsCirconscriptions 
    * en tableau de circonscription
    */
    public String[] obtenirNomsCirconscription(){
        return nomsCirconscriptions.toArray(new String[nomsCirconscriptions.size()]);
    }
    
    /**
    * Méthode qui permet de transformer la collection nomsParti 
    * en tableau de nomsParti
    */
    public String[] obtenirNomsParti(){
        return nomsParti.toArray(new String[nomsParti.size()]);
    }
    
    /**
    * Méthode qui permet de transformer la collection nomsDepute 
    * en tableau de nomsDepute
    */
    public String[] obtenirNomsDepute(){
        return nomsDepute.toArray(new String[nomsDepute.size()]);
    }
    
    /**
    * Méthode qui permet de générer le tableau index
    */
    public void genererIndex(){
        /**
         * stratégie: parcourir le tableau index et le remplir par du VIDE
         *            ensuite pour chaque objet depute dans la collection listeDepute
         *            mettre NoCaseCircons du depute sur la ligne du tableau, 
         *            NoCaseNomParti sur la colonne du tableau 
         *            enfin l'index de l'objet depute à l'intersection
         */ 
        index = new int[nomsCirconscriptions.size()][nomsParti.size()];
        
        for(int i = 0; i < index.length; i++){
            for(int j = 0; j < index[i].length; j++){
                index[i][j] = Constantes.VIDE;
            }
        }
        
        for (Depute objDep: listeDepute) {
            index[objDep.getNoCaseCircons() - 1][objDep.getNoCaseNomParti()] 
                    = listeDepute.indexOf(objDep);
        }
    }
    
    /***
     * Methode qui permet d'ajouter un parti
     * @param unParti le parti à ajouter
     */
     public void AjouterParti(Parti unParti){
            partis.add(unParti);
     }
     
    /*******
     * Méthode qui permet de créer un tableau d'objet Parti
     * @return Parti[] le tableau de Parti 
     */
    public Parti[] tabParti(){
        Parti[] tab = new Parti[partis.size()];
        return partis.toArray(tab);
    }
    
    /*******
     * Méthode qui permet d'obtenir le ième député
     * @return Depute le ième député
     */
    public Depute obtenirDepute(int i){
        return listeDepute.get(i);
    }
    
     /*******
     * Méthode qui permet d'obtenir le ième circonscription
     * @return Circonscription le ième circonscription
     */
    public Circonscription obtenirCirconscription(int i){
        return listeCirconscription.get(i);
    }
    
    /***
     * accesseur qui permet de trouver le nombre de député
     * @return le nombre de député
     */
    public int getNbreDepute(){
        return listeDepute.size();
    }
    
    /***
     * accesseur qui permet de trouver le nombre de circonscription
     * @return le nombre de circonscription
     */
    public int getNbreCirconscription(){
        return listeCirconscription.size();
    }
    
    /*******
     * Méthode qui permet d'ajouter le nom de l'OBNL
     * @param nomPartiGauche 
     */
    public void ajouterPartiGauche(String nomPartiGauche){
        if(!nomsPartisGauche.contains(nomPartiGauche)){
            nomsPartisGauche.add(nomPartiGauche);
        }
    }
    
    /******
     * Méthode utile pour connaitre la catégorie d'un parti
     * @param nomPartiDroite 
     */
    public void ajouterNomsPartiDroite(String nomPartiDroite){
        if(!nomsPartisDroite.contains(nomPartiDroite)){
            nomsPartisDroite.add(nomPartiDroite);
        }
    }
    
     /******
     * Méthode utile pour connaitre la catégorie d'un parti
     * @param nomPartiCentre 
     */
    public void ajouterNomsPartiCentre(String nomPartiCentre){
        if(!nomsPartisCentre.contains(nomPartiCentre)){
            nomsPartisCentre.add(nomPartiCentre);
        }
    }
    
    
}
