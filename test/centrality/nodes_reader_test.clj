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