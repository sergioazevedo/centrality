(ns centrality.nodes-reader-test
  (:require [clojure.test :refer :all])
  (:use centrality.nodes-reader)
)

(deftest add-1-new-node-to-graph
  (testing "build a graph representation from a array of arrays"
    (let [
        new-node ["A" "B"]
        graph (hash-map)
        result (add-node new-node graph)
      ]
      (is (= {:A ["B"] } result))
    )
  )
)

(deftest add-1-new-node-to-non-empty-graph
  (testing "build a graph representation from a array of arrays"
    (let [
        new-node ["A" "E"]
        graph {:A ["B"]}
        result (add-node new-node graph)
      ]
      (is (= {:A ["B" "E"] } result))
    )
  )
)

(deftest simple-hasMap-representation
  (testing "build a graph representation from a array of arrays"
    (let [
        nodes [ ["A" "B"] ["B" "C"] ]
        graph (build-graph-from nodes)
      ]
      (is (= {:A ["B"] :B ["C"] } graph))
    )
  )
)

(deftest hasMap-representation
  (testing "build a graph representation from a array of arrays"
    (let [
        nodes [ ["A" "B"] ["B" "C"] ["B" "D"] ["A" "E"] ]
        graph (build-graph-from nodes)
      ]
      (is (= {:E ["A"], :D ["B"], :C ["B"], :B ["C" "D" "A"], :A ["B" "E"]} graph) )
    )
  )
)