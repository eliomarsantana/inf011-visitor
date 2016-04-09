package visitor;

import visitor.interfaces.IVisitor;
import visitor.interfaces.IElement;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		List<IVisitor> visitors = new ArrayList<IVisitor>();
		List<IElement> elements = new ArrayList<IElement>();

		elements.add(new Aluno((short) 28, "Marcio"));
		elements.add(new Aluno((short) 15, "Maria"));
		elements.add(new Professor((short) 39, "Sandro"));

		IdadeMediaVisitor visitor = new IdadeMediaVisitor();
		NomeIniciaComVisitor nomeComVisitor = new NomeIniciaComVisitor("M");
		
		visitors.add(visitor);
		visitors.add(nomeComVisitor);

		for (IVisitor v : visitors) {
			for (IElement e : elements) {
				if (e instanceof Aluno)
					v.visit((Aluno) e);
				if (e instanceof Professor)
					v.visit((Professor) e);
			}
		}

		System.out.println(visitor.getIdadeMedia());
		System.out.println(nomeComVisitor.getContador());
	}

}
