package projetofinalpoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Monstro {
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    private int deslocamento;
    private float hp;
    private float cd;
    private String nome;
    private int i;
    private int d;

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public float getCd() {
        return cd;
    }

    public void setCd(float cd) {
        this.cd = cd;
    }
    
    

    public float getHp() {
        return hp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
    

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }
      
    
    
    
    
    
    
    
       @Override
    public String toString() {
        return "dados dos monstros";
    }
    
    
    public int dano (){
    
        System.out.println("dano do montro");
    
    return 0;
    }
    public void gravar() throws IOException{ 
    File arqFile = new File("Monstro"+this.getNome()+".txt");
    FileWriter arq = new FileWriter("Monstro"+this.getNome()+".txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.printf("Monstro: %n"+ getI() +  "%n" + getCd() + "%n" + getForca() + "%n"+ getDestreza() + "%n" + getConstituicao() + "%n"+ getInteligencia() + "%n" + getSabedoria() + "%n" + getCarisma() + "%n" + getDeslocamento()+ "%n" + getHp()+ "%n"+ getD());
    arq.close();
     }
    public void delete(){
        File arqFile = new File("Monstro"+this.getNome()+".txt");
        arqFile.delete();
    
    }
    }
    

