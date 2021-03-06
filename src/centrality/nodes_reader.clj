(ns centrality.nodes-reader
  (:gen-class))

(defn- extract-first-element-from-as-keyword
  [array]
  (keyword (get array 0) )
  )

(defn- extract-last-element-from
  [array]
  (get array 1)
  )

(defn- exist-key-in-graph
  [key graph]
  (contains? graph key)
  )

(defn- add-new-node-into-graph
  [new-node graph]
  (let[
    key (extract-first-element-from-as-keyword new-node)
    value (extract-last-element-from new-node)]

    (assoc graph key [value])
    )
  )

(defn- values-contains-new-value
  [value coll]
  (some #{value} coll)
)

(defn- append-new-value-to-graph-key
  [new-node graph]
  (let[
    key (extract-first-element-from-as-keyword new-node)
    values (get graph key )
    new-value (extract-last-element-from new-node)
    value-exists? (values-contains-new-value new-value values) ]
    (if value-exists?
      graph
      (assoc graph key (conj values new-value))
    )
  )
)

(defn add-node
  [new-node graph]
  (let[
    key (extract-first-element-from-as-keyword new-node)
    key-exists? (exist-key-in-graph key graph)]
    (if key-exists?
      (append-new-value-to-graph-key new-node graph)
      (add-new-node-into-graph new-node graph))))

(defn update-graph-with
  [node graph]
  (let [new-graph (add-node node @graph)]
    (reset! graph new-graph)
    graph))

(defn build-graph-from
  [nodes]
  (let[graph (atom (hash-map))]
    (doall
      (map (fn [n] (update-graph-with n graph)) nodes)
    )
    @graph))

(defn get-distance-between
  [v1 v2 graph]
  (let [
    values (get graph v1)
    found? (values-contains-new-value(values v2))]
  )
)

(defn try-reach-vertex-from
  [origin-list target graph]
  (map (fn[origin] (get-distance-between origin target)) origin-list)
)

(defn calculate-distances-of
  [vertex graph]
  (let[
    vertex-list (keys graph)
    distances (atom (hash-map))
    ]
    (doall
      (map (fn[v]( )) vertex-list)
    )
  )

)