package visitor;

import visitor.interfaces.IVisitor;
import visitor.interfaces.IElement;

public class Professor implements IElement {
	
	public Professor(short idade, String nome) {
		setIdade(idade);
		setNome(nome);
	}
	
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	private short idade;
	private String nome;
	public short getIdade() {
		return idade;
	}
	public void setIdade(short idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
