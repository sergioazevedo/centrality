(ns centrality.traverse
  (:gen-class))

(defn traverse-graph-dfs
  [graph strating-vertex]
  (loop
    [traversed-vertices [] explored #{strating-vertex} frontier [strating-vertex] ]
    (if (empty? frontier)
      traversed-vertices
      (let [
        next-starting-vertex-key ( keyword (peek frontier) )
        neighbors (get graph next-starting-vertex-key) ]
        (recur
          (conj traversed-vertices next-starting-vertex-key)
          (into explored neighbors)
          (into (pop frontier) (remove explored neighbors))
        )
      )
    )
  )
)

(defn rec-dfs
  [graph explored-vertices frontier-vertices]
  (println graph)
  (lazy-seq
    (if (empty? frontier-vertices)
      nil
      (let[
        next-vertice (keyword (peek frontier-vertices) )
        neighbors ( get graph next-vertice ) ]
        (cons next-vertice (rec-dfs
                              (into explored-vertices neighbors)
                              (into (pop frontier-vertices) (remove explored-vertices neighbors))
                            )
        )
      )
    )
  )
)

(defn seq-graph-dfs
  [graph strating-vertex]
  (rec-dfs graph #{strating-vertex} [strating-vertex])
)

