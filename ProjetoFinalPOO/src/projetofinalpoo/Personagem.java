package projetofinalpoo;
abstract class Personagem {
private String nome;
private String raca;
private String sexo;
private int idade;
private int forca=10;
private int destreza=10;
private int constituicao=10;
private int inteligencia=10;
private int sabedoria=10;
private int carisma=10;
private int deslocamento=10;
private String classe;

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }


//getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
        switch (this.raca) {
        case "anão":
        case "Anão":
            this.constituicao += 4;
            this.forca += 2;
            this.deslocamento -= 3;
            break;
        case "elfo":
        case "Elfo":
            this.destreza += 4;
            this.deslocamento += 2;
            this.sabedoria +=2;
            break;
        case "orc":
        case "Orc":
            this.constituicao += 2;
            this.forca += 4;
            break;
        case "humano":
        case "Humano":
            this.forca+=2;
            this.destreza += 2;
            this.constituicao += 2; 
            this.sabedoria +=2;
            this.inteligencia +=2;
            this.carisma +=2;
            break;
        case "tiefling":
        case "Tiefling":
            this.carisma +=4;
            this.inteligencia +=2;
            break;
        default:
            System.out.println("Raça invalidade, informe uma raça valida!!");
            System.exit(0);
            break;
    } 
        }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
        return carisma;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }
    //construtor

    public Personagem(String nome, String raca, String sexo, int idade) {
        this.nome=nome;
        this.setRaca(raca);
        this.sexo=sexo;
        this.idade=idade;
    }
    
   //metodos especiais

    @Override
    public String toString() {
        return "Personagem: \n" + "nome=" + getNome() +  "\n raca=" + getRaca() + "\n sexo=" + getSexo() + "\n idade=" + getIdade() + "\n forca=" + getForca() + "\n destreza=" + getDestreza() + "\n constituicao=" + getConstituicao() + "\n inteligencia=" + getInteligencia() + "\n sabedoria=" + getSabedoria() + "\n carisma=" + getCarisma() + "\n deslocamento=" + getDeslocamento();
    }
    
    
    public int dano(){
        System.out.println("dano do ataque");
    return 0;}
    public void correr(){
        System.out.println("correndo");}
}
