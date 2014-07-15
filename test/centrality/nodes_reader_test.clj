(ns centrality.nodes-reader-test
  (:require [clojure.test :refer :all])
  (:use centrality.nodes-reader)
)

(deftest nodes-reader-test
  (testing "build-graph returns a HashMap instance"
    (let [
        nodes [ ["A" "B"] ["B" "C"] ["B" "D"] ["A" "E"] ]
        graph (build-graph [nodes])
      ]
      (is (instance? clojure.lang.PersistentHashMap graph))
    )
  )
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
        graph ({:A ["B"]})
      ]
      (is (= {:A ["B" "E"] } result))
    )
  )
)

(deftest hasMap-representation
  (testing "build a graph representation from a array of arrays"
    (let [
        nodes [ ["A" "B"] ["B" "C"] ["B" "D"] ["A" "E"] ]
        graph (build-graph [nodes])
      ]
      (is (= {:A ["B" "E"] :B ["C" "D"] :C ["B"] :D ["B"] :E ["A"]} graph))
    )
  )
)