package undoredo;

import java.util.HashMap;
import java.util.Map;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import visualize.Edge;
import visualize.ExistException;
import visualize.Graph;
import visualize.Node;
import visualize.NotExistException;
import visualize.Visualization;

public class NodeRedelete extends AbstractUndoableEdit {
	
	private Map<String,Edge> edges;
	private String id;
	private int degree;
	private Color color;
	private double size;
	private String label;
	private Graph graph;
	private double x,y;
	HashMap<String,Color> colors;
	HashMap<String,String> labels;
	private Visualization visual;
	
	
	public NodeRedelete(Graph g,String idd,double xx,double yy,int dgr,Color col,double siz,String lab,HashMap<String,Color>clrs,HashMap<String,String>lbls,Visualization vis) {
		
		graph=g; id=idd; degree=dgr; color=col; size=siz; label=lab; colors=clrs; labels=lbls; x=xx; y=yy; visual=vis;
		
	}
	
	@Override
	public void redo() throws CannotRedoException {
		
		try {
			
			graph.removeNode(id);
			
		}catch(NotExistException e) {
			
			
		}
		
	}
	
	
	@Override
	public void undo() throws CannotUndoException {
	
		try {
			
			graph.addNode(id);
			Node n=graph.getNode(id);
			n.setDegree(degree);
			n.setColor(color);
			n.setSize(size);
			n.setLabel(label);
			n.setCenterX(x);
			n.setCenterY(y);
			
			visual.setDraggable(n); // needs to be set as draggable again
			
			for(String id1 : labels.keySet()) {
				
				graph.addEdge(id, id1, labels.get(id1));
				graph.getEdge(id, id1).setColor(colors.get(id1));
				
			}
			
		}catch(ExistException e) {
			
		}
		
	}
	
	

}
