package projetofinalpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MonstroTanque extends Monstro { 
    public MonstroTanque(float cd,String nome) throws IOException{
        this.setCd(cd);
        this.setNome(nome);
        this.setI(0);
        File arqFile = new File("Monstro"+this.getNome()+".txt");
     if(arqFile.exists()){
         String nome2 = "monstro"+this.getNome()+".txt";
 
    try {
      FileReader arq = new FileReader(nome2);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      linha = lerArq.readLine();
      linha = lerArq.readLine();
      linha = lerArq.readLine();
      this.setForca(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setDestreza(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setConstituicao(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setInteligencia(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setSabedoria(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setCarisma(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setDeslocamento(Integer.parseInt(linha));
      linha = lerArq.readLine();
      this.setHp(Float.parseFloat(linha));
      linha = lerArq.readLine();
      this.setD(Integer.parseInt(linha));
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
     }else{
        this.setConstituicao(new Random().nextInt(9)+12);
        this.setForca(new Random().nextInt(4)+10);
        this.setDestreza(new Random().nextInt(5)+8);
        this.setInteligencia(new Random().nextInt(4)+5);
        this.setSabedoria(new Random().nextInt(6)+8);
        this.setCarisma(new Random().nextInt(3)+6);
        this.setDeslocamento(new Random().nextInt(3)+6);
        this.setHp((float) ((15+((getConstituicao()-10)*0.5))*((3/2)*cd)));
          gravar();
     }}
    
   @Override
    public int dano(){
    int c = new Random().nextInt(20); 
    float z = new Random().nextInt(9)+this.getForca();
    z=(2+Math.round((float)z*(0.75)));
    System.out.println("ataque do Monstro, dano: "+ z);
    if(c==19){
    z=2*z;
    System.out.println("ataque do Monstro, dano CRITICO: "+ z);}
    return (int) z;
    }
   
   @Override
    public String toString() {
        return "Monstro Tanque: \n"  + "\n forca=" + getForca() + "\n destreza=" + getDestreza() + "\n constituicao=" + getConstituicao() + "\n inteligencia=" + getInteligencia() + "\n sabedoria=" + getSabedoria() + "\n carisma=" + getCarisma() + "\n deslocamento=" + getDeslocamento() + "\n hp= " +getHp() + "\n cd= " +getCd();
    }
             
    @Override
        public void gravar() throws IOException{ 
    File arqFile = new File("Monstro"+this.getNome()+".txt");
    FileWriter arq = new FileWriter("Monstro"+this.getNome()+".txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.printf("Monstro: %n"+ getCd() +  "%n" + getI() + "%n" + getForca() + "%n"+ getDestreza() + "%n" + getConstituicao() + "%n"+ getInteligencia() + "%n" + getSabedoria() + "%n" + getCarisma() + "%n" + getDeslocamento()+ "%n" + getHp()+ "%n"+ getD());
    arq.close();
     } 
    @Override
     public void delete(){
        File arqFile = new File("Monstro"+this.getNome()+".txt");
        arqFile.delete();}
}
   
