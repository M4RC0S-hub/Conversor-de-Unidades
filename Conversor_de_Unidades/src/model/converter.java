package model;

import javax.swing.JOptionPane;

public class converter {
    
    public String calcular(int conversor, int convertido, float numero, String tipo){

        int diferenca;
        final float pi=(float) 3.1415;
        diferenca = conversor - convertido;
        switch (tipo) {
            case "Volume":
                if (diferenca>0) {
                    for(int i=0; i<diferenca; i++){
                        numero = numero/1000;
                    }
                    
                } else if(diferenca<0){
                    for(int i=0; i>diferenca; i--){
                        numero = numero*1000;
                    }   
                }
                else{
                    ;
                }
                break;
        
            case "Distância":
            if (diferenca>0) {
                for(int i=0; i<diferenca; i++){
                    numero = numero/10;
                }
                
            } else if(diferenca<0){
                for(int i=0; i>diferenca; i--){
                    numero = numero*10;
                }
            }
            else{
                ;
            }
                break;
            case "Massa":
            if (diferenca>0) {
                for(int i=0; i<diferenca; i++){
                    numero = numero/1000;
                }
                
            } else if(diferenca<0){
                for(int i=0; i>diferenca; i--){
                    numero = numero*1000;
                } 
            }
            else{
                ;
            }
                break;
            case "Ângulo":
                if (diferenca<0) {
                    numero=(numero*pi)/180;
                }
                else if(diferenca>0){
                    numero=(numero*180)/pi;
                }
                else{
                    ;
                }
                break;
        }


        return Float.toString(numero);
    }
}