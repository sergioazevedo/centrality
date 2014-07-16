(ns centrality.nodes-reader
  (:gen-class))


(defn build-graph
  [nodes]
  (hash-map)
)

(defn- extract-first-element-from
  [array]
  (get array 0)
  )

(defn- extract-last-element-from
  [array]
  (get array 1)
  )

(defn add-node
  [new-node graph]
  (let[
    key (extract-first-element-from new-node)
    value (extract-last-element-from new-node)
    result {(keyword key) [value]}
    ]
    result
  ))
