package formats;

import java.io.*;

import visualize.Graph;

public abstract class Format {

	public abstract Graph  load(Graph g,File f);
}
