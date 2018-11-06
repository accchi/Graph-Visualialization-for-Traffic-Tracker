package undoredo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import javafx.scene.paint.Color;
import visualize.ExistException;
import visualize.Graph;
import visualize.NotExistException;

public class EdgeReadd extends AbstractUndoableEdit {

	private String id1,id2;
	private String label;
	private Graph graph;
	
	
	public EdgeReadd(Graph g,String id11,String id22,String lab) {
		
		id1=id11; id2=id22;  label=lab; graph=g;
		
	}
	
	@Override
	public void redo() throws CannotRedoException {
		
		try {
			
			graph.addEdge(id1, id2, label);
			
		}catch(ExistException e) {
			
		}
		
	}
	
	@Override
	public void undo() throws CannotUndoException {
		
		try {
			
			graph.removeEdge(id1, id2);
			
		}catch(NotExistException e) {
			
		}
		
	}
	
}
