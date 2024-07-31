package com.example.pfegestiondocument.Exeption;

public class TodoCollectionException extends  Exception{
    private static  final long serialVersionUID=1L;
    public  TodoCollectionException(String message){
        super(message);
    }
    public static String NotFoundExeption(String id){
        return  "TOdo with"+id+"not found!";
    }
    public static  String TodoAlAlreadyExists(){
        return "Todo with given name already exists!";
    }
}
