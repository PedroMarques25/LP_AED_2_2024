package edu.ufp.inf.projeto.JavaFXStuff;
/*

import edu.ufp.inf.projeto.JavaFXStuff.Autor;
import edu.ufp.inf.projeto.JavaFXStuff.AutorGraph;
import javafx.embed.swing.SwingNode;
import javafx.scene.layout.StackPane;

/*public class GrafoPane extends StackPane {

    private mxGraph graph;
    private mxGraphComponent graphComponent;

    public GrafoPane() {
        graph = new mxGraph();
        graphComponent = new mxGraphComponent(graph);

        SwingNode swingNode = new SwingNode();
        swingNode.setContent(graphComponent);

        getChildren().add(swingNode);
    }

    public void desenharGrafo(AutorGraph autorGraph) {
        graph.getModel().beginUpdate();
        try {
            Object parent = graph.getDefaultParent();
            Map<Integer, Object> vertices = new HashMap<>();

            for (Autor autor : autorGraph.getAutores().values()) {
                Object vertex = graph.insertVertex(parent, null, autor.getNome(), 0, 0, 80, 30);
                vertices.put(autor.getORCID(), vertex);
            }

            for (int v = 0; v < autorGraph.getGrafo().V(); v++) {
                for (int w : autorGraph.getGrafo().adj(v)) {
                    graph.insertEdge(parent, null, "", vertices.get(v), vertices.get(w));
                }
            }
        } finally {
            graph.getModel().endUpdate();
        }

        new mxCircleLayout(graph).execute(graph.getDefaultParent());
    }
}*/

