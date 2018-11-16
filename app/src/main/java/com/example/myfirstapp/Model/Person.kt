package com.example.myfirstapp.Model

class Person {
    var id:Int = 0
    var nom:String?=null
    var prenom:String?=null
    var adresse:String?=null
    var mail:String?=null
    var numero:String?=null

    constructor(){}

    constructor(id:Int, nom:String, prenom:String, adresse:String, mail:String, numero:String)
    {
        this.id=id
        this.nom=nom
        this.prenom=prenom
        this.adresse=adresse
        this.mail=mail
        this.numero=numero

    }
}