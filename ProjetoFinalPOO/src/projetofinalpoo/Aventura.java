package projetofinalpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Aventura {
 public Personagem player;   
 public Guerreiro player1;
 public Mago player2;
 public Arqueiro player3;
 public Monstro monstroAtual;
 private float cd;
 private int i;
 private int x;
 // metodos
 
 public Aventura(Personagem player ) throws IOException{
 if("Guerreiro".equals(player.getClasse())){
 this.player1 = (Guerreiro) player;
this.cd = player1.getNivel();
if(this.player1.getHpAtual()<1){
    System.out.println("Pessoas mortas não contam ou fazem historia, seu personagem pereceu nessa masmorra!!");
   }
this.x=1;
 }else if("Mago".equals(player.getClasse())){
 this.player2 = (Mago) player;
 this.cd = player2.getNivel();
 if(this.player2.getHpAtual()<1){
    System.out.println("Pessoas mortas não contam ou fazem historia, seu personagem pereceu nessa masmorra!!");
   }
 this.x=2;
 }else if("Arqueiro".equals(player.getClasse())){
 this.player3 = (Arqueiro) player;
 this.cd = player3.getNivel();
 if(this.player3.getHpAtual()<1){
    System.out.println("Pessoas mortas não contam ou fazem historia, seu personagem pereceu nessa masmorra!!");
    }
 x=3;
 }
 // monstro
 File arqFile = new File("Monstro"+player.getNome()+".txt");
     if(arqFile.exists()){
         String nome2 = "Monstro"+player.getNome()+".txt";
 
    try {
      FileReader arq = new FileReader(nome2);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      linha = lerArq.readLine();
      this.cd=Float.parseFloat(linha);
      linha = lerArq.readLine();
      if("0".equals(linha)){
            this.monstroAtual = new MonstroTanque(cd,player.getNome());}
      else if ("1".equals(linha)){
            this.monstroAtual = new MonstroAssasin(cd,player.getNome());}
      else if ("2".equals(linha)){
            this.monstroAtual = new MonstroEquili(cd,player.getNome());}
      else if("3".equals(linha)){
          this.monstroAtual = new MonstroMago(cd,player.getNome());}
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
     } else{
 i= new Random().nextInt(4);
 if(i==0){
 this.monstroAtual = new MonstroTanque(cd,player.getNome());
 }else if(i==1){
 this.monstroAtual = new MonstroAssasin(cd,player.getNome());
 } else if(i==2){
 this.monstroAtual = new MonstroEquili(cd,player.getNome());
 }else if(i==3){
 this.monstroAtual = new MonstroMago(cd,player.getNome());
 }
// metodos especiais 
 }}
public void atacar() throws IOException{
    if(x==1){
int a = new Random().nextInt(20);
if((a+1)>=10){
        System.out.println("ataque acertou!!");
        this.monstroAtual.setHp(this.monstroAtual.getHp() -this.player1.dano());
         monstroAtual.gravar();
        if(this.monstroAtual.getHp()<=1){
        vitoria();
        return;
        }}
else{
    System.out.println("ataque errou :( ");}        
int b = new Random().nextInt(20);
if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player1.setHpAtual(this.player1.getHpAtual()-this.monstroAtual.dano());
        player1.gravar();
        if(this.player1.getHpAtual()<=0){
        morrer();
        return;
        }}
else{
    System.out.println("O monstro errou :( ");}
    
    
    }
if(x==2){
int a = new Random().nextInt(20);
if((a+1)>=10){
        System.out.println("ataque acertou!!");
        this.monstroAtual.setHp(this.monstroAtual.getHp() -this.player2.dano());
        monstroAtual.gravar();
        if(this.monstroAtual.getHp()<=1){
        vitoria();
        return;
        }}
else{
    System.out.println("ataque errou :( ");}        
int b = new Random().nextInt(20);
if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player2.setHpAtual(this.player2.getHpAtual()-this.monstroAtual.dano());
        player2.gravar();
        if(this.player2.getHpAtual()<=0){
        morrer();
        return;
        }}
else{
    System.out.println("O monstro errou :( ");}
    
    
    }
if(x==3){
int a = new Random().nextInt(20);
if((a+1)>=10){
        System.out.println("ataque acertou!!");
        this.monstroAtual.setHp(this.monstroAtual.getHp() -this.player3.dano());
        monstroAtual.gravar();
        if(this.monstroAtual.getHp()<=1){
        vitoria();
        return;
        }}
else{
    System.out.println("ataque errou :( ");}        
int b = new Random().nextInt(20);
if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player3.setHpAtual(this.player3.getHpAtual()-this.monstroAtual.dano());
        player3.gravar();
        if(this.player3.getHpAtual()<=0){
        morrer();
        return;
        }}
else{
    System.out.println("O monstro errou :( ");}
    
    
    }

}

    public int getX() {
        return x;
    }
private void vitoria() throws IOException{
    System.out.println("PARABENS VOCÊ MATOU O MONSTRO!!");
    int c = Math.round(300*(this.monstroAtual.getCd()));
    if(x==1){
        this.player1.setXp(c);
        this.player1.gravar();}
    if(x==2){
        this.player2.setXp(c);
        this.player2.gravar();}
    if(x==3){
        this.player3.setXp(c);
        this.player3.gravar();}
    System.out.println("E ganhou " + c +" pontos de xp");
    status();
    monstroAtual.delete();
}
private void morrer() throws IOException{
if(x==1){
System.out.println("O bravo Guerreiro" + player1.getNome()+ " Pereceu na masmorra, mas não desista, crie e jogue uma nova aventura, mais sorte na proxima (ira precisar 3;) )");
this.player1.gravar();}

if(x==2){
    System.out.println("O Poderoso Mago" + player2.getNome()+ " Pereceu na masmorra, mas não desista, crie e jogue uma nova aventura, mais sorte na proxima (ira precisar 3;) )");
this.player2.gravar();}
if(x==3){
    System.out.println("O esguio Arqueiro" + player3.getNome()+ " Pereceu na masmorra, mas não desista, crie e jogue uma nova aventura, mais sorte na proxima (ira precisar 3;) )");
    this.player3.gravar();}
status();
monstroAtual.delete();
}
public void correr() throws IOException{
if(x==1){
monstroAtual.setD( monstroAtual.getD() + (this.player1.getDeslocamento() - this.monstroAtual.getDeslocamento()));
if(monstroAtual.getD() <=0){
    System.out.println("você não conseguiu se afastar do Monstro, ele é muito rapido");
    int b = new Random().nextInt(20);
    if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player1.setHpAtual(this.player1.getHpAtual()-this.monstroAtual.dano());
        player1.gravar();
        if(this.player1.getHpAtual()<=0){
        morrer();
        return;
        }}
else if(monstroAtual.getD() >=12){
    System.out.println("você conseguiu se afastar do alcance do monstro e fugir");
    monstroAtual.delete();
}else if(monstroAtual.getD() >=5){
    monstroAtual.gravar();
}
    System.out.println("você conseguiu sair do alcance do monstro em " + monstroAtual.getD() + " metros do monstro, mas ainda não o despistou");  
}else{
    System.out.println("você se afastou "+ monstroAtual.getD() + "metros do monstro, mas ainda esta no seu alcance...");
    monstroAtual.gravar();
    int b = new Random().nextInt(20);
    if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player1.setHpAtual(this.player1.getHpAtual()-this.monstroAtual.dano());
        player1.gravar();
        if(this.player1.getHpAtual()<=0){
        morrer();
        return;
        }}
else{
    System.out.println("O monstro errou :( ");}
}
}else if(x==2){
monstroAtual.setD( monstroAtual.getD() + (this.player2.getDeslocamento() - this.monstroAtual.getDeslocamento()));
if(monstroAtual.getD()<=0){
    System.out.println("você não conseguiu se afastar do Monstro, ele é muito rapido");
    int b = new Random().nextInt(20);
    if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        player2.gravar();
        this.player2.setHpAtual(this.player2.getHpAtual()-this.monstroAtual.dano());
        if(this.player2.getHpAtual()<=0){
        morrer();
        }}}
else if(monstroAtual.getD()>=12){
    System.out.println("você conseguiu se afastar do alcance do monstro e fugir");
    monstroAtual.delete();
}else if(monstroAtual.getD()>=5){
    monstroAtual.gravar();
    System.out.println("você conseguiu sair do alcance do monstro em " + monstroAtual.getD()+ " metros do monstro, mas ainda não o despistou");  
}else{
    monstroAtual.gravar();
    System.out.println("você se afastou "+ monstroAtual.getD()+ "metros do monstro, mas ainda esta no seu alcance...");
    int b = new Random().nextInt(20);
    if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        player2.gravar();
        this.player2.setHpAtual(this.player2.getHpAtual()-this.monstroAtual.dano());
        if(this.player2.getHpAtual()<=0){
        morrer();
        }}
else{
    System.out.println("O monstro errou :( ");}
}
}else if(x==3){
monstroAtual.setD( monstroAtual.getD() + (this.player3.getDeslocamento() - this.monstroAtual.getDeslocamento()));

if(monstroAtual.getD()<=0){
    System.out.println("você não conseguiu se afastar do Monstro, ele é muito rapido");
int b = new Random().nextInt(20);
    if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player3.setHpAtual(this.player3.getHpAtual()-this.monstroAtual.dano());
        player3.gravar();
        if(this.player3.getHpAtual()<=0){
        morrer();
        return;
        }}
else{
    System.out.println("O monstro errou :( ");}
}
else if(monstroAtual.getD()>=12){
    System.out.println("você conseguiu se afastar do alcance do monstro e fugir");
    monstroAtual.delete();
}else if(monstroAtual.getD()>=5){
    monstroAtual.gravar();
    System.out.println("você conseguiu sair do alcance do monstro em " + monstroAtual.getD()+ " metros do monstro, mas ainda não o despistou");  
}else{
    System.out.println("você se afastou "+ monstroAtual.getD()+ "metros do monstro, mas ainda esta no seu alcance...");
    int b = new Random().nextInt(20);
    if((b+1)>=10){
        System.out.println("o monstro te acertou 3:) !!");
        this.player3.setHpAtual(this.player3.getHpAtual()-this.monstroAtual.dano());
        player3.gravar();
        if(this.player3.getHpAtual()<=0){
        morrer();
        return;
        }}
else{
    System.out.println("O monstro errou :( ");}
}
}
}



public void status(){
    if(x==1){
        System.out.println(player1.toString() + "\n" + monstroAtual.toString());
    }else if(x==2){
        System.out.println(player2.toString() + "\n" +monstroAtual.toString());
    }else if(x==3){
        System.out.println(player3.toString() + "\n" +monstroAtual.toString());
    }
    
} 

}

