(ns centrality.nodes-reader
  (:gen-class))


(defn build-graph
  [nodes]
  (clojure.lang.PersistentHashMap/EMPTY)
)

(defn add-node
  [new-node graph]
  { (keyword (get new-node 0)) [(get new-node 1)]}
)