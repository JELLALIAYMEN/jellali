export interface Eleve {
  id: number,
  firstName: String,
  secondname: String,
  gmail: String,
  code: String,
  photo: String,
  classe : Classe
}
export interface  Classe{
  id_classe:number,

   nom:String
}

export interface Payment {
  id: number,
  date: String,
  amount: number,
  file: String,
  eleve: Eleve
}


export enum Typepay{
  Scolaire,
  Cantine,
}
export enum Statuspay {
  enattente,
  réussie,
  FAILED,
}
export enum Modepay {
  Mensiel,
  Annuel,
  trimestriel,
}
export enum Niveau {
  SEPT,
  HUIT,
  NEUF,
}

