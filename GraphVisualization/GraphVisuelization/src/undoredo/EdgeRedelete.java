package undoredo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import javafx.scene.paint.Color;
import visualize.ExistException;
import visualize.Graph;
import visualize.NotExistException;

public class EdgeRedelete extends AbstractUndoableEdit {

	private Graph graph;
	private String id1,id2;
	private Color color;
	private String label;
	
	
	public EdgeRedelete(Graph g,String id11,String id22,Color col,String lab) {
		
		graph=g; id1=id11; id2=id22; color=col; label=lab;
		
	}
	
	@Override
	public void redo() throws CannotRedoException {
		
		try {
			
			graph.removeEdge(id1, id2);
			
		}catch(NotExistException e) {
			
		}
		
	}
	
	@Override
	public void undo() throws CannotUndoException {
		
		try {
			
			graph.addEdge(id1, id2, label);
			graph.getEdge(id1, id2).setColor(color);
			
		}catch(ExistException e) {
			
		}
		
	}
}
