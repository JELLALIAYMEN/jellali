export interface Eleve {
  firstName: string;
  secondname: string;
  addrese: string;
  gmail: string;
  photo: string;
  niveau: string;
  id_classe: number;
  idel: number;
  code: string;

}

export interface  Classe{
  id_classe:number,

   nom:String
}


export interface Payment {
  id: number;
  date: string; // Changer String à string
  amount: number;
  file: string; // Changer String à string
  eleve: Eleve;
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

