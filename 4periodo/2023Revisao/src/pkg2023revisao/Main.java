package pkg2023revisao;

public class Main {
  public static void main(String[] args) {
    int balde2;
    int balde5;
    double balde33;
    int tinta2;
    int tinta5;
    double tinta33;
    double baldeAux;
    
    tinta2 = 2;
    tinta33 = 3.3;
    tinta5 = 5;
    
    balde2 = (int) tinta33;
    balde5 = tinta2;
    balde33 = tinta5;
    
    baldeAux = balde2;
    balde2 = balde5;
    balde5 = (int)balde33;
    balde33 = (int) baldeAux;
    
    System.out.println("balde 2: " +balde2);
    System.out.println("balde 5: " + balde5);
    System.out.println("balde 3.3: " + balde33);
    int result = sum(10);
    System.out.println(result);
  }    
  
  public static int sum(int k){
      if (k > 0){
          return k + sum(k-1);
      } else {
          return 0;
      }
  }
}
