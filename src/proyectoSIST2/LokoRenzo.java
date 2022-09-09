package Proyecto1;


public class LokoRenzo {
	  public static void main(String args[]) throws Exception {
	       
                //iniciar hilos
                Suma imprimir;
                 Suma s1, s2;
                 
                 
                 int[][] hola = new int[5][4];
        
        int largoFila=hola.length;
        int largoColumna=hola[0].length;
                
        largoFila=largoFila-1;
        
        for(int i=0;i<hola.length;i++){
            for(int j =0;j<hola[i].length;j++){
                
                System.out.print(hola[i][j]=j);
                
            }
        }
        System.out.println();
        
                 
                 
                 s1 = new Suma(1);
                 s2 = new Suma(2);
                
		 s1.start();
                 s2.start();
                 
                 try{
                    
                    s1.join();
                    s2.join();
                    
                 }catch(Exception e){
                     
                     //imprimir = new Suma(-1);
                     //imprimir.Imprimir();
                      
                     
                 }
                 
		 
	    }	    
}
