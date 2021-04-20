package projetofinalpoo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Guerreiro extends Personagem{
    private int nivel=1;
    private int xp=0;
    private int hp=10+(getConstituicao()-10)/2;
    private int hpAtual=hp;
    private String classe= "Guerreiro";
    final int x=300; 
    public int getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(int hpAtual) {
        this.hpAtual = hpAtual;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse() {
        this.classe = classe;
    }
    
    
    
    
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel() {
        this.nivel = nivel+1;
        this.setHp();
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        if(this.getXp()>=(x*this.nivel)){
            this.setNivel();
    }}

    public int getHp() {
        return hp;
    }

    public void setHp() {
        int y = new Random().nextInt(5);
        this.hp += (6+y+this.getConstituicao());
    }

    public Guerreiro(String nome, String raca, String sexo, int idade) throws IOException {
        super(nome, raca, sexo, idade);
     File arqFile = new File(this.getNome()+".txt");
     if(arqFile.exists()){
         String nome2 = this.getNome()+".txt";
 
    try {
      FileReader arq = new FileReader(nome2);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      linha = lerArq.readLine();
      this.setNome(linha);
      linha = lerArq.readLine();
      this.setRaca(linha);
      linha = lerArq.readLine();
      this.setSexo(linha);
      linha = lerArq.readLine();
      this.setIdade(Integer.parseInt(linha));
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
      this.classe = linha;
      linha = lerArq.readLine();
      this.nivel =Integer.parseInt(linha);
      linha = lerArq.readLine();
      this.xp =Integer.parseInt(linha);
      linha = lerArq.readLine();
      this.hp =Integer.parseInt(linha);
      linha = lerArq.readLine();
      this.hpAtual =Integer.parseInt(linha);
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
     } else{
    gravar();}
    }
    
    
    @Override
    public void correr(){
        System.out.println("correndo"+ this.getDeslocamento()+"metros");}
    @Override
    public int dano(){
    int c = new Random().nextInt(20); 
    int z = new Random().nextInt(9)+this.getForca();
    System.out.println("atacando com espada, dano: "+ z);
    if(c==19){
    z=2*z;
    System.out.println("atacando com ESPADA, dano CRITICO: "+ z);}
    return z;
    }

    @Override
    public String toString() {
    return  "Personagem: \n" + "nome=" + getNome() +  "\n raca=" + getRaca() + "\n sexo=" + getSexo() + "\n idade=" + getIdade() + "\n forca=" + getForca() + "\n destreza=" + getDestreza() + "\n constituicao=" + getConstituicao() + "\n inteligencia=" + getInteligencia() + "\n sabedoria=" + getSabedoria() + "\n carisma=" + getCarisma() + "\n deslocamento=" + getDeslocamento()+ "\n Classe =" + getClasse() +"\n nivel=" + getNivel() + "\n xp=" + getXp() + "\n hp=" + getHp()+ "\n Hp Atual=" + getHpAtual();
    }
   public void gravar() throws IOException{ 
     File arqFile = new File(this.getNome()+".txt");
    FileWriter arq = new FileWriter(this.getNome()+".txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.printf("Personagem: %n"+ getNome() +  "%n" + getRaca() + "%n" + getSexo() + "%n" + getIdade() + "%n" + getForca() + "%n"+ getDestreza() + "%n" + getConstituicao() + "%n"+ getInteligencia() + "%n" + getSabedoria() + "%n" + getCarisma() + "%n" + getDeslocamento()+ "%n" +getClasse() +"%n" + getNivel() + "%n" + getXp() + "%n" + getHp()+ "%n" + getHpAtual());
    arq.close();
     }
    
}
