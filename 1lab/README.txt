1 part: Basic Graph implementation with generics.

        Implemented both with adjacency list and adjacency matrix.
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
        Iterator<Integer> adj(T v)- adj. vertices to the given vertex.
        String toString() -         representing as string.
        
        Comments are generated with the help of JavaDoc.
        
        ToDo: debug, add unit tests, add generics, add a constructor to initialise 
        a graph from the .txt file, try to implement and visualise Djkistra's algorithm.
        
        
       
2 part: Database that operates on books.
        In progress(not yet implemented): Implemented a simple C.R.U.D application using Spring Framework.
        Project is built with Maven, to operate on database we use SQL and 
        JDBC.
        
        ToDo: add more features, try to implement users that can share their 
        comments on a book, play with Bootstrap to get beautiful design.
        
 More features: to be done.
