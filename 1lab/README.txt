<h1>1 part: Basic Graph implementation.</h1>

        Implemented generic graph DS both with adjacency list and adjacency matrix.
        To find the path between vertices we use methods from two classes
        named BreadthFirstPath and DepthFirstPath(that use BFS and DFS 
        respectfuly).
        
        I use Sedjewick's courses (Algorithms part 1,2) as the main study 
        reference.
        
        GRAPH API(for adjacencyList): 
        _____________________
        Graph() -                   constructor that creates an empty graph.
        int V()-                    method that returns number of vertices;
        int E()-                    method that returns number of edges;
        void addEdge(T v, T w)-     add edge in the graph.
        List<T> adj(T v)- adj. vertices to the given vertex.
        String toString() -         representing as string.
        
        Comments are generated with the help of JavaDoc.
        
        Unit testing is done with JUnit 5.        
        
        In perspective: implement Dijkstra algorithms and try to visualize it.
        
       
2 part: Database that operates on books.
        Implemented a simple C.R.U.D application using Spring Framework and 
        Jpa Repository functionality.
        Project is built with Maven, to operate on database we use SQL and JPA
        features.
        
        In perspective: add some design.
