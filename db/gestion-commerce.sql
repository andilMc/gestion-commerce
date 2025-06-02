/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 9.x                                */
/* Date de cr�ation :  6/1/2025 6:32:14 PM                      */
/*==============================================================*/
/*==============================================================*/
/* Table : Article                                              */
/*==============================================================*/
create table Article (
   idarticle            SERIAL               not null,
   idlot                INT4                 not null,
   idpromotion          INT4                 null,
   qrcode               VARCHAR(254)         null,
   prixachat            NUMERIC              null,
   prixvente            NUMERIC              null,
   tva                  NUMERIC              null,
   quantiteInitial      NUMERIC              null,
   statut               BOOL                 null,
   quantiteDisponible   NUMERIC              null,
   datecreation         DATE                 null,
   dateexpiration       DATE                 null,
   seiulAlert           NUMERIC              null,
   constraint PK_ARTICLE primary key (idarticle)
);

/*==============================================================*/
/* Index : ARTICLE_PK                                           */
/*==============================================================*/
create unique index ARTICLE_PK on Article (
idarticle
);

/*==============================================================*/
/* Index : ASSOCIATION3_FK                                      */
/*==============================================================*/
create  index ASSOCIATION3_FK on Article (
idpromotion
);

/*==============================================================*/
/* Index : ASSOCIATION5_FK                                      */
/*==============================================================*/
create  index ASSOCIATION5_FK on Article (
idlot
);

/*==============================================================*/
/* Table : AssoCompteCaisse                                     */
/*==============================================================*/
create table AssoCompteCaisse (
   idconnexion          INT4                 not null,
   idcaisse             INT4                 not null,
   heurDebut            VARCHAR(254)         null,
   heurFin              VARCHAR(254)         null,
   montantInitial       NUMERIC              null,
   montantFinal         NUMERIC              null,
   date                 DATE                 null,
   constraint PK_ASSOCOMPTECAISSE primary key (idconnexion, idcaisse)
);

/*==============================================================*/
/* Index : ASSOCOMPTECAISSE_PK                                  */
/*==============================================================*/
create unique index ASSOCOMPTECAISSE_PK on AssoCompteCaisse (
idconnexion,
idcaisse
);

/*==============================================================*/
/* Index : ASSOCIATION11_FK                                     */
/*==============================================================*/
create  index ASSOCIATION11_FK on AssoCompteCaisse (
idconnexion
);

/*==============================================================*/
/* Index : ASSOCIATION11_FK2                                    */
/*==============================================================*/
create  index ASSOCIATION11_FK2 on AssoCompteCaisse (
idcaisse
);

/*==============================================================*/
/* Table : AssoProduitUnite                                     */
/*==============================================================*/
create table AssoProduitUnite (
   idUnite              INT4                 not null,
   idProduit            INT4                 not null,
   date                 DATE                 null,
   constraint PK_ASSOPRODUITUNITE primary key (idUnite, idProduit)
);

/*==============================================================*/
/* Index : ASSOPRODUITUNITE_PK                                  */
/*==============================================================*/
create unique index ASSOPRODUITUNITE_PK on AssoProduitUnite (
idUnite,
idProduit
);

/*==============================================================*/
/* Index : ASSOCIATION44_FK                                     */
/*==============================================================*/
create  index ASSOCIATION44_FK on AssoProduitUnite (
idUnite
);

/*==============================================================*/
/* Table : AssoReportTransat                                    */
/*==============================================================*/
create table AssoReportTransat (
   idRapport            INT4                 not null,
   idTransaction        INT4                 not null,
   date                 DATE                 null,
   constraint PK_ASSOREPORTTRANSAT primary key (idRapport, idTransaction)
);

/*==============================================================*/
/* Index : ASSOREPORTTRANSAT_PK                                 */
/*==============================================================*/
create unique index ASSOREPORTTRANSAT_PK on AssoReportTransat (
idRapport,
idTransaction
);

/*==============================================================*/
/* Index : ASSOCIATION24_FK                                     */
/*==============================================================*/
create  index ASSOCIATION24_FK on AssoReportTransat (
idRapport
);

/*==============================================================*/
/* Index : ASSOCIATION24_FK2                                    */
/*==============================================================*/
create  index ASSOCIATION24_FK2 on AssoReportTransat (
idTransaction
);

/*==============================================================*/
/* Table : Boutique                                             */
/*==============================================================*/
create table Boutique (
   idBoutique           SERIAL               not null,
   idconnexion          INT4                 null,
   nomBoutique          VARCHAR(254)         null,
   reference            VARCHAR(254)         null,
   dateCreation         DATE                 null,
   constraint PK_BOUTIQUE primary key (idBoutique)
);

/*==============================================================*/
/* Index : BOUTIQUE_PK                                          */
/*==============================================================*/
create unique index BOUTIQUE_PK on Boutique (
idBoutique
);

/*==============================================================*/
/* Index : ASSOCIATION45_FK                                     */
/*==============================================================*/
create  index ASSOCIATION45_FK on Boutique (
idconnexion
);

/*==============================================================*/
/* Table : Caisse                                               */
/*==============================================================*/
create table Caisse (
   idcaisse             SERIAL               not null,
   dateOuverture        DATE                 null,
   dateFermeture        DATE                 null,
   statut               VARCHAR(254)         null,
   constraint PK_CAISSE primary key (idcaisse)
);

/*==============================================================*/
/* Index : CAISSE_PK                                            */
/*==============================================================*/
create unique index CAISSE_PK on Caisse (
idcaisse
);

/*==============================================================*/
/* Table : Casquette                                            */
/*==============================================================*/
create table Casquette (
   idCasquette          SERIAL               not null,
   idpersonne           INT4                 not null,
   idcollaborateur      INT4                 not null,
   libelle              VARCHAR(254)         null,
   constraint PK_CASQUETTE primary key (idCasquette)
);

/*==============================================================*/
/* Index : CASQUETTE_PK                                         */
/*==============================================================*/
create unique index CASQUETTE_PK on Casquette (
idCasquette
);

/*==============================================================*/
/* Index : ASSOCIATION22_FK                                     */
/*==============================================================*/
create  index ASSOCIATION22_FK on Casquette (
idpersonne,
idcollaborateur
);

/*==============================================================*/
/* Table : Catalogue                                            */
/*==============================================================*/
create table Catalogue (
   idcatalogue          SERIAL               not null,
   reference            VARCHAR(254)         null,
   label                VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   datecreation         DATE                 null,
   etat                 BOOL                 null,
   constraint PK_CATALOGUE primary key (idcatalogue)
);

/*==============================================================*/
/* Index : CATALOGUE_PK                                         */
/*==============================================================*/
create unique index CATALOGUE_PK on Catalogue (
idcatalogue
);

/*==============================================================*/
/* Table : CategorieTransaction                                 */
/*==============================================================*/
create table CategorieTransaction (
   idCatTrans           SERIAL               not null,
   nom                  VARCHAR(254)         null,
   type                 VARCHAR(254)         null,
   constraint PK_CATEGORIETRANSACTION primary key (idCatTrans)
);

/*==============================================================*/
/* Index : CATEGORIETRANSACTION_PK                              */
/*==============================================================*/
create unique index CATEGORIETRANSACTION_PK on CategorieTransaction (
idCatTrans
);

/*==============================================================*/
/* Table : Client                                               */
/*==============================================================*/
create table Client (
   idpersonne           INT4                 not null,
   idclient             SERIAL               not null,
   matricule            VARCHAR(254)         null,
   constraint PK_CLIENT primary key (idpersonne, idclient)
);

/*==============================================================*/
/* Index : CLIENT_PK                                            */
/*==============================================================*/
create unique index CLIENT_PK on Client (
idpersonne,
idclient
);

/*==============================================================*/
/* Index : GENERALIZATION_2_FK                                  */
/*==============================================================*/
create  index GENERALIZATION_2_FK on Client (
idpersonne
);

/*==============================================================*/
/* Table : Collaborateur                                        */
/*==============================================================*/
create table Collaborateur (
   idpersonne           INT4                 not null,
   idcollaborateur      SERIAL               not null,
   idSociete            INT4                 not null,
   label                VARCHAR(254)         null,
   datecreation         DATE                 null,
   description          VARCHAR(254)         null,
   constraint PK_COLLABORATEUR primary key (idpersonne, idcollaborateur)
);

/*==============================================================*/
/* Index : COLLABORATEUR_PK                                     */
/*==============================================================*/
create unique index COLLABORATEUR_PK on Collaborateur (
idpersonne,
idcollaborateur
);

/*==============================================================*/
/* Index : ASSOCIATION21_FK                                     */
/*==============================================================*/
create  index ASSOCIATION21_FK on Collaborateur (
idSociete
);

/*==============================================================*/
/* Index : GENERALISATION_3_FK                                  */
/*==============================================================*/
create  index GENERALISATION_3_FK on Collaborateur (
idpersonne
);

/*==============================================================*/
/* Table : Compte                                               */
/*==============================================================*/
create table Compte (
   idconnexion          SERIAL               not null,
   idpersonne           INT4                 not null,
   identifiant          VARCHAR(254)         null,
   motdepasse           VARCHAR(254)         null,
   datecreation         DATE                 null,
   etat                 VARCHAR(254)         null,
   constraint PK_COMPTE primary key (idconnexion)
);

/*==============================================================*/
/* Index : COMPTE_PK                                            */
/*==============================================================*/
create unique index COMPTE_PK on Compte (
idconnexion
);

/*==============================================================*/
/* Index : ASSOCIATION4_FK                                      */
/*==============================================================*/
create  index ASSOCIATION4_FK on Compte (
idpersonne
);

/*==============================================================*/
/* Table : Conge                                                */
/*==============================================================*/
create table Conge (
   idConge              SERIAL               not null,
   idpersonne           INT4                 not null,
   idemployer           INT4                 not null,
   typeConge            VARCHAR(254)         null,
   dateDebut            DATE                 null,
   dateFin              DATE                 null,
   statutConge          VARCHAR(254)         null,
   constraint PK_CONGE primary key (idConge)
);

/*==============================================================*/
/* Index : CONGE_PK                                             */
/*==============================================================*/
create unique index CONGE_PK on Conge (
idConge
);

/*==============================================================*/
/* Index : ASSOCIATION9_FK                                      */
/*==============================================================*/
create  index ASSOCIATION9_FK on Conge (
idpersonne,
idemployer
);

/*==============================================================*/
/* Table : ContratTravail                                       */
/*==============================================================*/
create table ContratTravail (
   idContrat            SERIAL               not null,
   idpaye               INT4                 not null,
   idpersonne           INT4                 not null,
   idemployer           INT4                 not null,
   idsalaire            INT4                 not null,
   idtypecontract       INT4                 not null,
   dateDebut            DATE                 null,
   dateFin              DATE                 null,
   statutContrat        VARCHAR(254)         null,
   constraint PK_CONTRATTRAVAIL primary key (idContrat)
);

/*==============================================================*/
/* Index : CONTRATTRAVAIL_PK                                    */
/*==============================================================*/
create unique index CONTRATTRAVAIL_PK on ContratTravail (
idContrat
);

/*==============================================================*/
/* Index : ASSOCIATION26_FK                                     */
/*==============================================================*/
create  index ASSOCIATION26_FK on ContratTravail (
idtypecontract
);

/*==============================================================*/
/* Index : ASSOCIATION25_FK                                     */
/*==============================================================*/
create  index ASSOCIATION25_FK on ContratTravail (
idsalaire
);

/*==============================================================*/
/* Index : ASSOCIATION28_FK                                     */
/*==============================================================*/
create  index ASSOCIATION28_FK on ContratTravail (
idpaye
);

/*==============================================================*/
/* Index : ASSOCIATION27_FK                                     */
/*==============================================================*/
create  index ASSOCIATION27_FK on ContratTravail (
idpersonne,
idemployer
);

/*==============================================================*/
/* Table : DetaiProduit                                         */
/*==============================================================*/
create table DetaiProduit (
   iddetailproduit      SERIAL               not null,
   idProduit            INT4                 null,
   label                VARCHAR(254)         null,
   etat                 NUMERIC              null,
   datecreation         DATE                 null,
   constraint PK_DETAIPRODUIT primary key (iddetailproduit)
);

/*==============================================================*/
/* Index : DETAIPRODUIT_PK                                      */
/*==============================================================*/
create unique index DETAIPRODUIT_PK on DetaiProduit (
iddetailproduit
);

/*==============================================================*/
/* Index : ASSOCIATION6_FK                                      */
/*==============================================================*/
create  index ASSOCIATION6_FK on DetaiProduit (
idProduit
);

/*==============================================================*/
/* Table : DetailVente                                          */
/*==============================================================*/
create table DetailVente (
   idvente              INT4                 not null,
   idarticle            INT4                 not null,
   quantite             NUMERIC              null,
   prixunitaire         NUMERIC              null,
   prixTotal            NUMERIC              null,
   constraint PK_DETAILVENTE primary key (idvente, idarticle)
);

/*==============================================================*/
/* Index : DETAILVENTE_PK                                       */
/*==============================================================*/
create unique index DETAILVENTE_PK on DetailVente (
idvente,
idarticle
);

/*==============================================================*/
/* Index : ASSOCIATION19_FK                                     */
/*==============================================================*/
create  index ASSOCIATION19_FK on DetailVente (
idvente
);

/*==============================================================*/
/* Index : ASSOCIATION19_FK2                                    */
/*==============================================================*/
create  index ASSOCIATION19_FK2 on DetailVente (
idarticle
);

/*==============================================================*/
/* Table : Employer                                             */
/*==============================================================*/
create table Employer (
   idpersonne           INT4                 not null,
   idemployer           SERIAL               not null,
   idposte              INT4                 not null,
   idBoutique           INT4                 null,
   matricule            VARCHAR(254)         null,
   constraint PK_EMPLOYER primary key (idpersonne, idemployer)
);

/*==============================================================*/
/* Index : EMPLOYER_PK                                          */
/*==============================================================*/
create unique index EMPLOYER_PK on Employer (
idpersonne,
idemployer
);

/*==============================================================*/
/* Index : ASSOCIATION8_FK                                      */
/*==============================================================*/
create  index ASSOCIATION8_FK on Employer (
idposte
);

/*==============================================================*/
/* Index : ASSOCIATION34_FK                                     */
/*==============================================================*/
create  index ASSOCIATION34_FK on Employer (
idBoutique
);

/*==============================================================*/
/* Index : GENERALIZATION_3_FK                                  */
/*==============================================================*/
create  index GENERALIZATION_3_FK on Employer (
idpersonne
);

/*==============================================================*/
/* Table : Facture                                              */
/*==============================================================*/
create table Facture (
   idfacture            SERIAL               not null,
   idvente              INT4                 not null,
   reference            VARCHAR(254)         null,
   datefacture          DATE                 null,
   montant              NUMERIC              null,
   constraint PK_FACTURE primary key (idfacture)
);

/*==============================================================*/
/* Index : FACTURE_PK                                           */
/*==============================================================*/
create unique index FACTURE_PK on Facture (
idfacture
);

/*==============================================================*/
/* Index : ASSOCIATION15_FK                                     */
/*==============================================================*/
create  index ASSOCIATION15_FK on Facture (
idvente
);

/*==============================================================*/
/* Table : Famille                                              */
/*==============================================================*/
create table Famille (
   idfamille            SERIAL               not null,
   idcatalogue          INT4                 null,
   reference            VARCHAR(254)         null,
   label                VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   datecreation         DATE                 null,
   etat                 BOOL                 null,
   constraint PK_FAMILLE primary key (idfamille)
);

/*==============================================================*/
/* Index : FAMILLE_PK                                           */
/*==============================================================*/
create unique index FAMILLE_PK on Famille (
idfamille
);

/*==============================================================*/
/* Index : ASSOCIATION18_FK                                     */
/*==============================================================*/
create  index ASSOCIATION18_FK on Famille (
idcatalogue
);

/*==============================================================*/
/* Table : Historique                                           */
/*==============================================================*/
create table Historique (
   idHistorique         SERIAL               not null,
   idconnexion          INT4                 null,
   action               VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   date                 DATE                 null,
   constraint PK_HISTORIQUE primary key (idHistorique)
);

/*==============================================================*/
/* Index : HISTORIQUE_PK                                        */
/*==============================================================*/
create unique index HISTORIQUE_PK on Historique (
idHistorique
);

/*==============================================================*/
/* Index : ASSOCIATION17_FK                                     */
/*==============================================================*/
create  index ASSOCIATION17_FK on Historique (
idconnexion
);

/*==============================================================*/
/* Table : Image                                                */
/*==============================================================*/
create table Image (
   idimage              SERIAL               not null,
   idarticle            INT4                 null,
   path                 VARCHAR(254)         null,
   constraint PK_IMAGE primary key (idimage)
);

/*==============================================================*/
/* Index : IMAGE_PK                                             */
/*==============================================================*/
create unique index IMAGE_PK on Image (
idimage
);

/*==============================================================*/
/* Index : ASSOCIATION12_FK                                     */
/*==============================================================*/
create  index ASSOCIATION12_FK on Image (
idarticle
);

/*==============================================================*/
/* Table : Livraison                                            */
/*==============================================================*/
create table Livraison (
   idLivraison          SERIAL               not null,
   idarticle            INT4                 not null,
   idpersonne           INT4                 not null,
   idcollaborateur      INT4                 not null,
   idvente              INT4                 not null,
   reference            VARCHAR(254)         null,
   statut               BOOL                 null,
   date                 DATE                 null,
   type                 VARCHAR(254)         null,
   constraint PK_LIVRAISON primary key (idLivraison)
);

/*==============================================================*/
/* Index : LIVRAISON_PK                                         */
/*==============================================================*/
create unique index LIVRAISON_PK on Livraison (
idLivraison
);

/*==============================================================*/
/* Index : ASSOCIATION39_FK                                     */
/*==============================================================*/
create  index ASSOCIATION39_FK on Livraison (
idpersonne,
idcollaborateur
);

/*==============================================================*/
/* Index : ASSOCIATION40_FK                                     */
/*==============================================================*/
create  index ASSOCIATION40_FK on Livraison (
idvente
);

/*==============================================================*/
/* Index : ASSOCIATION41_FK                                     */
/*==============================================================*/
create  index ASSOCIATION41_FK on Livraison (
idarticle
);

/*==============================================================*/
/* Table : Lot                                                  */
/*==============================================================*/
create table Lot (
   idlot                SERIAL               not null,
   idProduit            INT4                 not null,
   idstock              INT4                 not null,
   idBoutique           INT4                 null,
   reference            INT4                 null,
   libelle              VARCHAR(254)         null,
   decription           VARCHAR(254)         null,
   statut               INT4                 null,
   datemodification     INT4                 null,
   datecreation         INT4                 null,
   constraint PK_LOT primary key (idlot)
);

/*==============================================================*/
/* Index : LOT_PK                                               */
/*==============================================================*/
create unique index LOT_PK on Lot (
idlot
);

/*==============================================================*/
/* Index : ASSOCIATION2_FK                                      */
/*==============================================================*/
create  index ASSOCIATION2_FK on Lot (
idProduit
);

/*==============================================================*/
/* Index : ASSOCIATION13_FK                                     */
/*==============================================================*/
create  index ASSOCIATION13_FK on Lot (
idstock
);

/*==============================================================*/
/* Index : ASSOCIATION35_FK                                     */
/*==============================================================*/
create  index ASSOCIATION35_FK on Lot (
idBoutique
);

/*==============================================================*/
/* Table : ModePayement                                         */
/*==============================================================*/
create table ModePayement (
   idmodepayement       SERIAL               not null,
   typemode             VARCHAR(254)         null,
   constraint PK_MODEPAYEMENT primary key (idmodepayement)
);

/*==============================================================*/
/* Index : MODEPAYEMENT_PK                                      */
/*==============================================================*/
create unique index MODEPAYEMENT_PK on ModePayement (
idmodepayement
);

/*==============================================================*/
/* Table : MotifRetour                                          */
/*==============================================================*/
create table MotifRetour (
   idMotif              SERIAL               not null,
   idRetoure            INT4                 not null,
   libelle              VARCHAR(254)         null,
   constraint PK_MOTIFRETOUR primary key (idMotif)
);

/*==============================================================*/
/* Index : MOTIFRETOUR_PK                                       */
/*==============================================================*/
create unique index MOTIFRETOUR_PK on MotifRetour (
idMotif
);

/*==============================================================*/
/* Index : ASSOCIATION37_FK                                     */
/*==============================================================*/
create  index ASSOCIATION37_FK on MotifRetour (
idRetoure
);

/*==============================================================*/
/* Table : Paiement                                             */
/*==============================================================*/
create table Paiement (
   idpaiement           SERIAL               not null,
   idmodepayement       INT4                 not null,
   idfacture            INT4                 not null,
   montantPaye          NUMERIC              null,
   datepaiement         DATE                 null,
   statutPaiement       VARCHAR(254)         null,
   constraint PK_PAIEMENT primary key (idpaiement)
);

/*==============================================================*/
/* Index : PAIEMENT_PK                                          */
/*==============================================================*/
create unique index PAIEMENT_PK on Paiement (
idpaiement
);

/*==============================================================*/
/* Index : ASSOCIATION14_FK                                     */
/*==============================================================*/
create  index ASSOCIATION14_FK on Paiement (
idfacture
);

/*==============================================================*/
/* Index : ASSOCIATION16_FK                                     */
/*==============================================================*/
create  index ASSOCIATION16_FK on Paiement (
idmodepayement
);

/*==============================================================*/
/* Table : Patterne                                             */
/*==============================================================*/
create table Patterne (
   idPatterne           SERIAL               not null,
   idconnexion          INT4                 not null,
   prefixe              VARCHAR(254)         null,
   suffixe              VARCHAR(254)         null,
   class                VARCHAR(254)         null,
   colonne              VARCHAR(254)         null,
   constraint PK_PATTERNE primary key (idPatterne)
);

/*==============================================================*/
/* Index : PATTERNE_PK                                          */
/*==============================================================*/
create unique index PATTERNE_PK on Patterne (
idPatterne
);

/*==============================================================*/
/* Index : ASSOCIATION42_FK                                     */
/*==============================================================*/
create  index ASSOCIATION42_FK on Patterne (
idconnexion
);

/*==============================================================*/
/* Table : PayementSalaire                                      */
/*==============================================================*/
create table PayementSalaire (
   idpaye               SERIAL               not null,
   montant              NUMERIC              null,
   dateeffectif         DATE                 null,
   etat                 VARCHAR(254)         null,
   periodicite          VARCHAR(254)         null,
   period               VARCHAR(254)         null,
   constraint PK_PAYEMENTSALAIRE primary key (idpaye)
);

/*==============================================================*/
/* Index : PAYEMENTSALAIRE_PK                                   */
/*==============================================================*/
create unique index PAYEMENTSALAIRE_PK on PayementSalaire (
idpaye
);

/*==============================================================*/
/* Table : Penalite                                             */
/*==============================================================*/
create table Penalite (
   idpenalite           SERIAL               not null,
   idpersonne           INT4                 not null,
   idemployer           INT4                 not null,
   datepenalite         DATE                 null,
   motif                VARCHAR(254)         null,
   sanction             VARCHAR(254)         null,
   constraint PK_PENALITE primary key (idpenalite)
);

/*==============================================================*/
/* Index : PENALITE_PK                                          */
/*==============================================================*/
create unique index PENALITE_PK on Penalite (
idpenalite
);

/*==============================================================*/
/* Index : ASSOCIATION10_FK                                     */
/*==============================================================*/
create  index ASSOCIATION10_FK on Penalite (
idpersonne,
idemployer
);

/*==============================================================*/
/* Table : Permission                                           */
/*==============================================================*/
create table Permission (
   idpermission         SERIAL               not null,
   libelle              VARCHAR(254)         null,
   reference            VARCHAR(254)         null,
   etat                 BOOL                 null,
   dateCreation         DATE                 null,
   description          VARCHAR(254)         null,
   constraint PK_PERMISSION primary key (idpermission)
);

/*==============================================================*/
/* Index : PERMISSION_PK                                        */
/*==============================================================*/
create unique index PERMISSION_PK on Permission (
idpermission
);

/*==============================================================*/
/* Table : Personne                                             */
/*==============================================================*/
create table Personne (
   idpersonne           SERIAL               not null,
   idProfile            INT4                 not null,
   nom                  VARCHAR(254)         null,
   prenom               VARCHAR(254)         null,
   email                VARCHAR(254)         null,
   telephone            VARCHAR(254)         null,
   dateNaissance        DATE                 null,
   photoProfil          VARCHAR(254)         null,
   dateInscription      DATE                 null,
   pays                 VARCHAR(254)         null,
   adresse              VARCHAR(254)         null,
   codepostal           VARCHAR(254)         null,
   constraint PK_PERSONNE primary key (idpersonne)
);

/*==============================================================*/
/* Index : PERSONNE_PK                                          */
/*==============================================================*/
create unique index PERSONNE_PK on Personne (
idpersonne
);

/*==============================================================*/
/* Index : ASSOCIATION29_FK                                     */
/*==============================================================*/
create  index ASSOCIATION29_FK on Personne (
idProfile
);

/*==============================================================*/
/* Table : Poste                                                */
/*==============================================================*/
create table Poste (
   idposte              SERIAL               not null,
   titre                VARCHAR(254)         null,
   descriptionPoste     VARCHAR(254)         null,
   constraint PK_POSTE primary key (idposte)
);

/*==============================================================*/
/* Index : POSTE_PK                                             */
/*==============================================================*/
create unique index POSTE_PK on Poste (
idposte
);

/*==============================================================*/
/* Table : Produit                                              */
/*==============================================================*/
create table Produit (
   idProduit            SERIAL               not null,
   idfamille            INT4                 null,
   reference            VARCHAR(254)         null,
   designation          VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   etat                 BOOL                 null,
   datecreation         DATE                 null,
   constraint PK_PRODUIT primary key (idProduit)
);

/*==============================================================*/
/* Index : PRODUIT_PK                                           */
/*==============================================================*/
create unique index PRODUIT_PK on Produit (
idProduit
);

/*==============================================================*/
/* Index : ASSOCIATION1_FK                                      */
/*==============================================================*/
create  index ASSOCIATION1_FK on Produit (
idfamille
);

/*==============================================================*/
/* Table : Profile                                              */
/*==============================================================*/
create table Profile (
   idProfile            SERIAL               not null,
   libelle              VARCHAR(254)         null,
   constraint PK_PROFILE primary key (idProfile)
);

/*==============================================================*/
/* Index : PROFILE_PK                                           */
/*==============================================================*/
create unique index PROFILE_PK on Profile (
idProfile
);

/*==============================================================*/
/* Table : Promotion                                            */
/*==============================================================*/
create table Promotion (
   idpromotion          SERIAL               not null,
   titrePromotion       VARCHAR(254)         null,
   dateDebut            DATE                 null,
   dateFin              DATE                 null,
   pourcentageReduction FLOAT8               null,
   codePromo            VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   nombreUtilisationsMax INT4                 null,
   nombreUtilisationsActuel INT4                 null,
   constraint PK_PROMOTION primary key (idpromotion)
);

/*==============================================================*/
/* Index : PROMOTION_PK                                         */
/*==============================================================*/
create unique index PROMOTION_PK on Promotion (
idpromotion
);

/*==============================================================*/
/* Table : RapportFinancier                                     */
/*==============================================================*/
create table RapportFinancier (
   idRapport            SERIAL               not null,
   idconnexion          INT4                 null,
   periode              VARCHAR(254)         null,
   dateDebut            DATE                 null,
   dateFin              DATE                 null,
   totaleEntries        NUMERIC              null,
   totaleSorties        NUMERIC              null,
   solde                NUMERIC              null,
   constraint PK_RAPPORTFINANCIER primary key (idRapport)
);

/*==============================================================*/
/* Index : RAPPORTFINANCIER_PK                                  */
/*==============================================================*/
create unique index RAPPORTFINANCIER_PK on RapportFinancier (
idRapport
);

/*==============================================================*/
/* Index : ASSOCIATION30_FK                                     */
/*==============================================================*/
create  index ASSOCIATION30_FK on RapportFinancier (
idconnexion
);

/*==============================================================*/
/* Table : RetourProduit                                        */
/*==============================================================*/
create table RetourProduit (
   idRetoure            INT4                 not null,
   idarticle            INT4                 not null,
   idvente              INT4                 not null,
   quantiteRetournee    NUMERIC              null,
   dateRetour           DATE                 null,
   motif                VARCHAR(254)         null,
   statut               VARCHAR(254)         null,
   actionAppliquee      VARCHAR(254)         null,
   type                 VARCHAR(254)         null,
   constraint PK_RETOURPRODUIT primary key (idRetoure)
);

/*==============================================================*/
/* Index : RETOURPRODUIT_PK                                     */
/*==============================================================*/
create unique index RETOURPRODUIT_PK on RetourProduit (
idRetoure
);

/*==============================================================*/
/* Index : ASSOCIATION36_FK                                     */
/*==============================================================*/
create  index ASSOCIATION36_FK on RetourProduit (
idvente
);

/*==============================================================*/
/* Index : ASSOCIATION38_FK                                     */
/*==============================================================*/
create  index ASSOCIATION38_FK on RetourProduit (
idarticle
);

/*==============================================================*/
/* Table : Role                                                 */
/*==============================================================*/
create table Role (
   idconnexion          INT4                 not null,
   idpermission         INT4                 not null,
   datecreation         VARCHAR(254)         null,
   etat                 BOOL                 null,
   constraint PK_ROLE primary key (idconnexion, idpermission)
);

/*==============================================================*/
/* Index : ROLE_PK                                              */
/*==============================================================*/
create unique index ROLE_PK on Role (
idconnexion,
idpermission
);

/*==============================================================*/
/* Index : ASSOCIATION7_FK                                      */
/*==============================================================*/
create  index ASSOCIATION7_FK on Role (
idconnexion
);

/*==============================================================*/
/* Index : ASSOCIATION7_FK2                                     */
/*==============================================================*/
create  index ASSOCIATION7_FK2 on Role (
idpermission
);

/*==============================================================*/
/* Table : Salaire                                              */
/*==============================================================*/
create table Salaire (
   idsalaire            SERIAL               not null,
   idvarietesalaire     INT4                 not null,
   montant              NUMERIC              null,
   date                 DATE                 null,
   constraint PK_SALAIRE primary key (idsalaire)
);

/*==============================================================*/
/* Index : SALAIRE_PK                                           */
/*==============================================================*/
create unique index SALAIRE_PK on Salaire (
idsalaire
);

/*==============================================================*/
/* Index : ASSOCIATION32_FK                                     */
/*==============================================================*/
create  index ASSOCIATION32_FK on Salaire (
idvarietesalaire
);

/*==============================================================*/
/* Table : Societe                                              */
/*==============================================================*/
create table Societe (
   idSociete            SERIAL               not null,
   nomSociete           VARCHAR(254)         null,
   address              VARCHAR(254)         null,
   phone                VARCHAR(254)         null,
   constraint PK_SOCIETE primary key (idSociete)
);

/*==============================================================*/
/* Index : SOCIETE_PK                                           */
/*==============================================================*/
create unique index SOCIETE_PK on Societe (
idSociete
);

/*==============================================================*/
/* Table : Stock                                                */
/*==============================================================*/
create table Stock (
   idstock              SERIAL               not null,
   designation          VARCHAR(254)         null,
   qrcode               VARCHAR(254)         null,
   datecreation         DATE                 null,
   etat                 BOOL                 null,
   datemodification     INT4                 null,
   constraint PK_STOCK primary key (idstock)
);

/*==============================================================*/
/* Index : STOCK_PK                                             */
/*==============================================================*/
create unique index STOCK_PK on Stock (
idstock
);

/*==============================================================*/
/* Table : Transaction                                          */
/*==============================================================*/
create table Transaction (
   idTransaction        SERIAL               not null,
   idconnexion          INT4                 not null,
   idCatTrans           INT4                 null,
   type                 VARCHAR(254)         null,
   montant              NUMERIC              null,
   description          VARCHAR(254)         null,
   categorie            VARCHAR(254)         null,
   date                 DATE                 null,
   validee              BOOL                 null,
   source               VARCHAR(254)         null,
   constraint PK_TRANSACTION primary key (idTransaction)
);

/*==============================================================*/
/* Index : TRANSACTION_PK                                       */
/*==============================================================*/
create unique index TRANSACTION_PK on Transaction (
idTransaction
);

/*==============================================================*/
/* Index : ASSOCIATION23_FK                                     */
/*==============================================================*/
create  index ASSOCIATION23_FK on Transaction (
idCatTrans
);

/*==============================================================*/
/* Index : ASSOCIATION33_FK                                     */
/*==============================================================*/
create  index ASSOCIATION33_FK on Transaction (
idconnexion
);

/*==============================================================*/
/* Table : TypeContrat                                          */
/*==============================================================*/
create table TypeContrat (
   idtypecontract       SERIAL               not null,
   libelle              VARCHAR(254)         null,
   etat                 VARCHAR(254)         null,
   datecreation         DATE                 null,
   constraint PK_TYPECONTRAT primary key (idtypecontract)
);

/*==============================================================*/
/* Index : TYPECONTRAT_PK                                       */
/*==============================================================*/
create unique index TYPECONTRAT_PK on TypeContrat (
idtypecontract
);

/*==============================================================*/
/* Table : TypeVariete                                          */
/*==============================================================*/
create table TypeVariete (
   idTypeVariete        SERIAL               not null,
   label                VARCHAR(254)         null,
   typevaleur           VARCHAR(254)         null,
   etat                 VARCHAR(254)         null,
   datecreation         DATE                 null,
   constraint PK_TYPEVARIETE primary key (idTypeVariete)
);

/*==============================================================*/
/* Index : TYPEVARIETE_PK                                       */
/*==============================================================*/
create unique index TYPEVARIETE_PK on TypeVariete (
idTypeVariete
);

/*==============================================================*/
/* Table : UniteMesure                                          */
/*==============================================================*/
create table UniteMesure (
   idUnite              SERIAL               not null,
   libelle              VARCHAR(254)         null,
   symbole              VARCHAR(254)         null,
   constraint PK_UNITEMESURE primary key (idUnite)
);

/*==============================================================*/
/* Index : UNITEMESURE_PK                                       */
/*==============================================================*/
create unique index UNITEMESURE_PK on UniteMesure (
idUnite
);

/*==============================================================*/
/* Table : Variete                                              */
/*==============================================================*/
create table Variete (
   idarticle            INT4                 not null,
   idTypeVariete        INT4                 not null,
   idvariete            SERIAL               not null,
   valeur               VARCHAR(254)         null,
   etat                 BOOL                 null,
   datecreation         DATE                 null,
   constraint PK_VARIETE primary key (idarticle, idTypeVariete, idvariete)
);

/*==============================================================*/
/* Index : VARIETE_PK                                           */
/*==============================================================*/
create unique index VARIETE_PK on Variete (
idarticle,
idTypeVariete,
idvariete
);

/*==============================================================*/
/* Index : ASSOCIATION43_FK                                     */
/*==============================================================*/
create  index ASSOCIATION43_FK on Variete (
idarticle
);

/*==============================================================*/
/* Index : ASSOCIATION43_FK2                                    */
/*==============================================================*/
create  index ASSOCIATION43_FK2 on Variete (
idTypeVariete
);

/*==============================================================*/
/* Table : VarieteSalaire                                       */
/*==============================================================*/
create table VarieteSalaire (
   idvarietesalaire     SERIAL               not null,
   libellevariete       VARCHAR(254)         null,
   datecreation         DATE                 null,
   constraint PK_VARIETESALAIRE primary key (idvarietesalaire)
);

/*==============================================================*/
/* Index : VARIETESALAIRE_PK                                    */
/*==============================================================*/
create unique index VARIETESALAIRE_PK on VarieteSalaire (
idvarietesalaire
);

/*==============================================================*/
/* Table : Vente                                                */
/*==============================================================*/
create table Vente (
   idvente              SERIAL               not null,
   idpersonne           INT4                 not null,
   idclient             INT4                 not null,
   idconnexion          INT4                 not null,
   idcaisse             INT4                 not null,
   reference            INT4                 null,
   datecommande         DATE                 null,
   montantTotal         NUMERIC              null,
   modePaiement         VARCHAR(254)         null,
   statut               VARCHAR(254)         null,
   date                 DATE                 null,
   constraint PK_VENTE primary key (idvente)
);

/*==============================================================*/
/* Index : VENTE_PK                                             */
/*==============================================================*/
create unique index VENTE_PK on Vente (
idvente
);

/*==============================================================*/
/* Index : ASSOCIATION20_FK                                     */
/*==============================================================*/
create  index ASSOCIATION20_FK on Vente (
idpersonne,
idclient
);

/*==============================================================*/
/* Index : ASSOCIATION31_FK                                     */
/*==============================================================*/
create  index ASSOCIATION31_FK on Vente (
idconnexion,
idcaisse
);

alter table Article
   add constraint FK_ARTICLE_ASSOCIATI_PROMOTIO foreign key (idpromotion)
      references Promotion (idpromotion)
      on delete restrict on update restrict;

alter table Article
   add constraint FK_ARTICLE_ASSOCIATI_LOT foreign key (idlot)
      references Lot (idlot)
      on delete restrict on update restrict;

alter table AssoCompteCaisse
   add constraint FK_ASSOCOMP_ASSOCIATI_CAISSE foreign key (idcaisse)
      references Caisse (idcaisse)
      on delete restrict on update restrict;

alter table AssoCompteCaisse
   add constraint FK_ASSOCOMP_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table AssoProduitUnite
   add constraint FK_ASSOPROD_ASSOCIATI_PRODUIT foreign key (idProduit)
      references Produit (idProduit)
      on delete restrict on update restrict;

alter table AssoProduitUnite
   add constraint FK_ASSOPROD_ASSOCIATI_UNITEMES foreign key (idUnite)
      references UniteMesure (idUnite)
      on delete restrict on update restrict;

alter table AssoReportTransat
   add constraint FK_ASSOREPO_ASSOCIATI_RAPPORTF foreign key (idRapport)
      references RapportFinancier (idRapport)
      on delete restrict on update restrict;

alter table AssoReportTransat
   add constraint FK_ASSOREPO_ASSOCIATI_TRANSACT foreign key (idTransaction)
      references Transaction (idTransaction)
      on delete restrict on update restrict;

alter table Boutique
   add constraint FK_BOUTIQUE_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table Casquette
   add constraint FK_CASQUETT_ASSOCIATI_COLLABOR foreign key (idpersonne, idcollaborateur)
      references Collaborateur (idpersonne, idcollaborateur)
      on delete restrict on update restrict;

alter table Client
   add constraint FK_CLIENT_GENERALIZ_PERSONNE foreign key (idpersonne)
      references Personne (idpersonne)
      on delete restrict on update restrict;

alter table Collaborateur
   add constraint FK_COLLABOR_GENERALIS_PERSONNE foreign key (idpersonne)
      references Personne (idpersonne)
      on delete restrict on update restrict;

alter table Collaborateur
   add constraint FK_COLLABOR_ASSOCIATI_SOCIETE foreign key (idSociete)
      references Societe (idSociete)
      on delete restrict on update restrict;

alter table Compte
   add constraint FK_COMPTE_ASSOCIATI_PERSONNE foreign key (idpersonne)
      references Personne (idpersonne)
      on delete restrict on update restrict;

alter table Conge
   add constraint FK_CONGE_ASSOCIATI_EMPLOYER foreign key (idpersonne, idemployer)
      references Employer (idpersonne, idemployer)
      on delete restrict on update restrict;

alter table ContratTravail
   add constraint FK_CONTRATT_ASSOCIATI_SALAIRE foreign key (idsalaire)
      references Salaire (idsalaire)
      on delete restrict on update restrict;

alter table ContratTravail
   add constraint FK_CONTRATT_ASSOCIATI_TYPECONT foreign key (idtypecontract)
      references TypeContrat (idtypecontract)
      on delete restrict on update restrict;

alter table ContratTravail
   add constraint FK_CONTRATT_ASSOCIATI_EMPLOYER foreign key (idpersonne, idemployer)
      references Employer (idpersonne, idemployer)
      on delete restrict on update restrict;

alter table ContratTravail
   add constraint FK_CONTRATT_ASSOCIATI_PAYEMENT foreign key (idpaye)
      references PayementSalaire (idpaye)
      on delete restrict on update restrict;

alter table DetaiProduit
   add constraint FK_DETAIPRO_ASSOCIATI_PRODUIT foreign key (idProduit)
      references Produit (idProduit)
      on delete restrict on update restrict;

alter table DetailVente
   add constraint FK_DETAILVE_ASSOCIATI_ARTICLE foreign key (idarticle)
      references Article (idarticle)
      on delete restrict on update restrict;

alter table DetailVente
   add constraint FK_DETAILVE_ASSOCIATI_VENTE foreign key (idvente)
      references Vente (idvente)
      on delete restrict on update restrict;

alter table Employer
   add constraint FK_EMPLOYER_GENERALIZ_PERSONNE foreign key (idpersonne)
      references Personne (idpersonne)
      on delete restrict on update restrict;

alter table Employer
   add constraint FK_EMPLOYER_ASSOCIATI_BOUTIQUE foreign key (idBoutique)
      references Boutique (idBoutique)
      on delete restrict on update restrict;

alter table Employer
   add constraint FK_EMPLOYER_ASSOCIATI_POSTE foreign key (idposte)
      references Poste (idposte)
      on delete restrict on update restrict;

alter table Facture
   add constraint FK_FACTURE_ASSOCIATI_VENTE foreign key (idvente)
      references Vente (idvente)
      on delete restrict on update restrict;

alter table Famille
   add constraint FK_FAMILLE_ASSOCIATI_CATALOGU foreign key (idcatalogue)
      references Catalogue (idcatalogue)
      on delete restrict on update restrict;

alter table Historique
   add constraint FK_HISTORIQ_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table Image
   add constraint FK_IMAGE_ASSOCIATI_ARTICLE foreign key (idarticle)
      references Article (idarticle)
      on delete restrict on update restrict;

alter table Livraison
   add constraint FK_LIVRAISO_ASSOCIATI_COLLABOR foreign key (idpersonne, idcollaborateur)
      references Collaborateur (idpersonne, idcollaborateur)
      on delete restrict on update restrict;

alter table Livraison
   add constraint FK_LIVRAISO_ASSOCIATI_VENTE foreign key (idvente)
      references Vente (idvente)
      on delete restrict on update restrict;

alter table Livraison
   add constraint FK_LIVRAISO_ASSOCIATI_ARTICLE foreign key (idarticle)
      references Article (idarticle)
      on delete restrict on update restrict;

alter table Lot
   add constraint FK_LOT_ASSOCIATI_STOCK foreign key (idstock)
      references Stock (idstock)
      on delete restrict on update restrict;

alter table Lot
   add constraint FK_LOT_ASSOCIATI_PRODUIT foreign key (idProduit)
      references Produit (idProduit)
      on delete restrict on update restrict;

alter table Lot
   add constraint FK_LOT_ASSOCIATI_BOUTIQUE foreign key (idBoutique)
      references Boutique (idBoutique)
      on delete restrict on update restrict;

alter table MotifRetour
   add constraint FK_MOTIFRET_ASSOCIATI_RETOURPR foreign key (idRetoure)
      references RetourProduit (idRetoure)
      on delete restrict on update restrict;

alter table Paiement
   add constraint FK_PAIEMENT_ASSOCIATI_FACTURE foreign key (idfacture)
      references Facture (idfacture)
      on delete restrict on update restrict;

alter table Paiement
   add constraint FK_PAIEMENT_ASSOCIATI_MODEPAYE foreign key (idmodepayement)
      references ModePayement (idmodepayement)
      on delete restrict on update restrict;

alter table Patterne
   add constraint FK_PATTERNE_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table Penalite
   add constraint FK_PENALITE_ASSOCIATI_EMPLOYER foreign key (idpersonne, idemployer)
      references Employer (idpersonne, idemployer)
      on delete restrict on update restrict;

alter table Personne
   add constraint FK_PERSONNE_ASSOCIATI_PROFILE foreign key (idProfile)
      references Profile (idProfile)
      on delete restrict on update restrict;

alter table Produit
   add constraint FK_PRODUIT_ASSOCIATI_FAMILLE foreign key (idfamille)
      references Famille (idfamille)
      on delete restrict on update restrict;

alter table RapportFinancier
   add constraint FK_RAPPORTF_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table RetourProduit
   add constraint FK_RETOURPR_ASSOCIATI_VENTE foreign key (idvente)
      references Vente (idvente)
      on delete restrict on update restrict;

alter table RetourProduit
   add constraint FK_RETOURPR_ASSOCIATI_ARTICLE foreign key (idarticle)
      references Article (idarticle)
      on delete restrict on update restrict;

alter table Role
   add constraint FK_ROLE_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table Role
   add constraint FK_ROLE_ASSOCIATI_PERMISSI foreign key (idpermission)
      references Permission (idpermission)
      on delete restrict on update restrict;

alter table Salaire
   add constraint FK_SALAIRE_ASSOCIATI_VARIETES foreign key (idvarietesalaire)
      references VarieteSalaire (idvarietesalaire)
      on delete restrict on update restrict;

alter table Transaction
   add constraint FK_TRANSACT_ASSOCIATI_CATEGORI foreign key (idCatTrans)
      references CategorieTransaction (idCatTrans)
      on delete restrict on update restrict;

alter table Transaction
   add constraint FK_TRANSACT_ASSOCIATI_COMPTE foreign key (idconnexion)
      references Compte (idconnexion)
      on delete restrict on update restrict;

alter table Variete
   add constraint FK_VARIETE_ASSOCIATI_ARTICLE foreign key (idarticle)
      references Article (idarticle)
      on delete restrict on update restrict;

alter table Variete
   add constraint FK_VARIETE_ASSOCIATI_TYPEVARI foreign key (idTypeVariete)
      references TypeVariete (idTypeVariete)
      on delete restrict on update restrict;

alter table Vente
   add constraint FK_VENTE_ASSOCIATI_CLIENT foreign key (idpersonne, idclient)
      references Client (idpersonne, idclient)
      on delete restrict on update restrict;

alter table Vente
   add constraint FK_VENTE_ASSOCIATI_ASSOCOMP foreign key (idconnexion, idcaisse)
      references AssoCompteCaisse (idconnexion, idcaisse)
      on delete restrict on update restrict;

