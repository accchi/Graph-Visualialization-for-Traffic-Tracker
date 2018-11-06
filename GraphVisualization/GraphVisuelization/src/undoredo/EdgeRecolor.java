package undoredo;

import java.util.HashMap;
import java.util.HashSet;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import visualize.Edge;
import javafx.scene.paint.Color;


public class EdgeRecolor extends AbstractUndoableEdit {

	private Color newColor;
	private HashSet<Edge> edges;
	private HashMap<Edge,Color> oldColor;
	
	public EdgeRecolor(HashMap<Edge,Color> oldC,Color newC,HashSet<Edge> e) {
		
		oldColor=oldC; newColor=newC; edges=e;
		
	}
	
	@Override
	public void redo() throws CannotRedoException {
		
		for(Edge e : edges) { // iterate throught nodes and set new size to them
			
			e.setColor(newColor);
		
		}
		
		
	}
	
	@Override
	public void undo() throws CannotUndoException { // iterate throught nodes and set old size to them
		
		for(Edge e : edges) {
			
			e.setColor(oldColor.get(e));
		
		}
		
	}
	
	
}
