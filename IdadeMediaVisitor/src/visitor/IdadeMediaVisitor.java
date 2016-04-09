package visitor;

import visitor.interfaces.ICore;
import visitor.interfaces.IPlugin;
import visitor.interfaces.IVisitor;

public class IdadeMediaVisitor implements IVisitor, IPlugin {

	private int acumuladorIdade = 0;
	private int quantidade = 0;

	@Override
	public void visit(Aluno aluno) {
		quantidade++;
		acumuladorIdade += aluno.getIdade();
	}

	@Override
	public void visit(Professor professor) {
		quantidade++;
		acumuladorIdade += professor.getIdade();
	}

	public float getIdadeMedia() {
		return acumuladorIdade / ((float) quantidade);
	}

    @Override
    public void visit(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize(ICore core) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
