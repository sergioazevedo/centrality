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