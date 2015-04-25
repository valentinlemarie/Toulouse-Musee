import musee.Adresse
import musee.AdresseService
import musee.GestionaireService
import musee.Gestionnaire
import musee.Musee
import musee.MuseeService

class BootStrap {

    AdresseService adresseService
    GestionaireService gestionaireService
    MuseeService museeService

    String ville = "TOULOUSE"

    Adresse adresse1 = new Adresse(rue: "RUE DES ARCHIVES",numero: 2,codePostal: "31500",ville: ville)
    Adresse adresse2 = new Adresse(rue: "RUE SAINT PANTALEONl",numero: 5,codePostal: "31000",ville: ville)
    Adresse adresse3 = new Adresse(rue: "RUE PARGAMINIERES",numero: 69,codePostal: "31000",ville: ville)
    Adresse adresse4 = new Adresse(rue: "RUE DE LA FONDERIE",numero: 31,codePostal: "31000",ville: ville)
    Adresse adresse5 = new Adresse(rue: "RUE MONTMORENCY",numero: 1,codePostal: "31200",ville: ville)
    Adresse adresse6 = new Adresse(rue: "RUE VIGUERIE",numero: 2,codePostal: "31300",ville: ville)
    Adresse adresse7 = new Adresse(rue: "RUE DE METZ",numero: 21,codePostal: "31000",ville: ville)
    Adresse adresse8 = new Adresse(rue: "RUE TRIPIERE",numero: 2,codePostal: "31000",ville: ville)
    Adresse adresse9 = new Adresse(rue: "RUE VIGUERIE",numero: 2,codePostal: "31300",ville: ville)
    Adresse adresse10 = new Adresse(rue: "RUE DU MAY",numero: 7,codePostal: "31000",ville: ville)
    Adresse adresse11 = new Adresse(rue: "RUE DU JAPON",numero: 1,codePostal: "31400",ville: ville)
    Adresse adresse12 = new Adresse(rue: "RUE DE LA PLEAU",numero: 13,codePostal: "31000",ville: ville)

    Gestionnaire gestionnaire1 = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
    Gestionnaire gestionnaire2 = new Gestionnaire(nom: "Association")
    Gestionnaire gestionnaire3 = new Gestionnaire(nom: "Autre institution publique")
    Gestionnaire gestionnaire4 = new Gestionnaire(nom: "Structure commerciale")

    Musee musee1 = new Musee(status: false,accesMetro: "Roseraie (A)",accesBus:"36, 38",nom: "ARCHIVES MUNICIPALES TOULOUSE",telephone:"0561616333",horairesOuverture:"Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.")
    Musee musee2 = new Musee(status: false,accesMetro: "Capitole (A), Jean Jaurès (B)",accesBus:"ncv, 2, 10, 12, 14, 38, 78 et 80",nom: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE",telephone:"0561233049",horairesOuverture:"Ouvert du mardi au samedi de 13h à 19hfermé les dimanches, jours fériés et du 1er au 15 août")
    Musee musee3 = new Musee(status: false,accesMetro: "Esquirol, Capitole (A)",accesBus:"NCV, 2, 10, 12, 14, 38, 78, 80",nom: "ENSEMBLE CONVENTUEL DES JACOBINS",telephone:"0561222192",horairesOuverture:"Ouvert tous les jours de 9h à 19h."    )
    Musee musee4 = new Musee(status: false,accesMetro: "Carmes (B)",accesBus:"2, 38",nom: "INSTITUT CATHOLIQUE DE TOULOUSE - ESPACE MUSEOGRAPHIQUE BACCRABERE - SALLE TOLOSA",telephone:"0561368112",horairesOuverture:"Ouvert le premier vendredi de chaque mois de 18h à 20h.")
    Musee musee5 = new Musee(status: false,nom: "L'AEROTHEQUE",telephone:"0561939357",horairesOuverture:"Ouvert le lundi et le mercredi de 14h à 17h et le mardi de 9h à 12h"    )
    Musee musee6 = new Musee(status: false,accesMetro:  "Saint-Cyprien-République, Esquirol (A)",accesBus:"2, 10, 12, 14, 78, 80",nom: "MUSEE DE L'HISTOIRE DE LA MEDECINE DE TOULOUSE",telephone:"0561778425",horairesOuverture:"Ouvert tous les jeudi et vendredi de 11h à 17h, et le dimande de 10h à 18h.Visites guidées sur demande."    )
    Musee musee7 = new Musee(status: false,accesMetro:  "Esquirol (A) ou Carmes (B)",accesBus:"ncv, 2, 10, 14, 38, 78, 80",nom: "MUSEE DES AUGUSTINS - MUSEE DES BEAUX ARTS DE TOULOUSE",telephone:"0561222182",horairesOuverture:"Tous les jours : 10h - 18h /  nocturne le mercredi jusqu'à 21h."    )
    Musee musee8 = new Musee(status: false,accesMetro:  "Esquirol, Capitole (A)",accesBus:"2, 10, 12, 14, 38, 78, 80",nom: "MUSEE DES COMPAGNONS",telephone:"0561474177",horairesOuverture:"Le Mercredi et le 1er dimanche de chaque mois de 14h à 17h"    )
    Musee musee9 = new Musee(status: false,accesMetro:  "Saint-Cyprien-République, Esquirol (A)",accesBus:"2, 10, 12, 14, 78, 80",nom: "MUSEE DES INSTRUMENTS DE MEDECINE DES HOPITAUX DE TOULOUSE",telephone:"0561778272",horairesOuverture:"Ouvert tous les jeudi et vendredi de 13h à 17h. Ouvert le premier dimanche du mois.Visites guidées sur demande."    )
    Musee musee10 = new Musee(status: false,accesMetro: "Esquirol, Capitole (A)" ,accesBus:"2, 10, 12, 14, 38, 78, 80",nom: "MUSEE DU VIEUX TOULOUSE",telephone:"0561271150",horairesOuverture:"Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet."    )
    Musee musee11 = new Musee(status: false,accesMetro: "François Verdier (B)",accesBus:"10, 2, 27",nom: "MUSEE GEORGES-LABIT",telephone:"0561146550",horairesOuverture:"Ouvert tous les jours du 2 mai au 31 octobre de 14h00 à 18h00.Fermé le dimanche et jours fériés."    )
    Musee musee12 = new Musee(status: false,accesMetro: "Esquirol (A) Carmes (B)",accesBus:"ncv, 2, 12, 52",nom: "MUSEE PAUL-DUPUY - ARTS GRAPHIQUES ET ARTS DECORATIFS",telephone:"0561146550",horairesOuverture:"Ouvert de 10h - 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermé le mardi et jours fériés."    )
    def init = { servletContext ->

        gestionaireService.insertOrUpdateGestionnaire(gestionnaire1)
        gestionaireService.insertOrUpdateGestionnaire(gestionnaire2)
        gestionaireService.insertOrUpdateGestionnaire(gestionnaire3)
        gestionaireService.insertOrUpdateGestionnaire(gestionnaire4)

        adresseService.insertOrUpdateAdresse(adresse1)
        adresseService.insertOrUpdateAdresse(adresse2)
        adresseService.insertOrUpdateAdresse(adresse3)
        adresseService.insertOrUpdateAdresse(adresse4)
        adresseService.insertOrUpdateAdresse(adresse5)
        adresseService.insertOrUpdateAdresse(adresse6)
        adresseService.insertOrUpdateAdresse(adresse7)
        adresseService.insertOrUpdateAdresse(adresse8)
        adresseService.insertOrUpdateAdresse(adresse9)
        adresseService.insertOrUpdateAdresse(adresse10)
        adresseService.insertOrUpdateAdresse(adresse11)
        adresseService.insertOrUpdateAdresse(adresse12)

        museeService.insertOrUpdateMusee(musee1 ,adresse1,gestionnaire1)
        museeService.insertOrUpdateMusee(musee2,adresse2,gestionnaire2)
        museeService.insertOrUpdateMusee(musee3,adresse3,gestionnaire1)
        museeService.insertOrUpdateMusee(musee4,adresse4,gestionnaire3)
        museeService.insertOrUpdateMusee(musee5,adresse5,gestionnaire4)
        museeService.insertOrUpdateMusee(musee6,adresse6,gestionnaire2)
        museeService.insertOrUpdateMusee(musee7,adresse7,gestionnaire1)
        museeService.insertOrUpdateMusee(musee8,adresse8,gestionnaire2)
        museeService.insertOrUpdateMusee(musee9,adresse9,gestionnaire4)
        museeService.insertOrUpdateMusee(musee10,adresse10,gestionnaire2)
        museeService.insertOrUpdateMusee(musee11,adresse11,gestionnaire1)
        museeService.insertOrUpdateMusee(musee12,adresse12,gestionnaire1)

    }
    def destroy = {
    }
}
