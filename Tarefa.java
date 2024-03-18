public class Tarefa{


private String nome;
private String descricao;
private String status;

public Tarefa(String nome, String descricao){
    this.nome = nome;
    this.descricao = descricao;
    this.status = "Pendente";
}

public void setNome(String nome){
    this.nome = nome;
}
public String getNome(){
    return nome;
}

public void setDescricao(String descricao){
    this.descricao = descricao;
}
public String getDescricao(){
    return descricao;
}

public void setstatus(String status){
    this.status = status;
}
public String getStatus(){
return status;
}

@Override
public String toString(){
    return "Nome: " + getNome() + 
    "\nDescricao: " + getDescricao() + 
    "\nStatus: " + getStatus();
}
}
