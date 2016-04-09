package visitor;

import visitor.Aluno;
import visitor.Professor;
import visitor.interfaces.IVisitor;

public class NomeIniciaComVisitor implements IVisitor {
	
	private String prefixo;
	private int contador = 0;
	
	public NomeIniciaComVisitor(String c) {
		prefixo = c;
	}

	@Override
	public void visit(Aluno aluno) {
		if(aluno.getNome().startsWith(prefixo))
			contador++;
		
	}

	@Override
	public void visit(Professor professor) {
		if(professor.getNome().startsWith(prefixo))
			contador++;
		
	}
	
	public int getContador() {
		return contador;
	}
}
