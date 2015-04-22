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
      (is (= {:B ["C" "D"], :A ["B" "E"]} graph) )
    )
  )
)

; (deftest test-get-distance-between
;   (testing "given a graph and two vertexes calculate the distance between them"
;     (let [
;         nodes [ ["A" "B"] ["B" "C"] ["B" "D"] ["A" "E"] ]
;         graph (build-graph-from nodes)
;         distance (get-distance-between "A" "D" graph)
;       ]
;       (println "distance =>")
;       (println distance)
;       (is (= 2 distance))
;     )
;   )
; )

; (deftest test-calculate-distances-from-vertex
;   (testing "given a graph and a vertex v calculate all distances for this vertex"
;     (let [
;         nodes [ ["A" "B"] ["B" "C"] ["B" "D"] ["A" "E"] ]
;         graph (build-graph-from nodes)
;         centrality (calculate-distances-of "A" graph)
;         expected-result {:AA 0 :AB 1 :AC 2 :AD 2 :AE 1 }
;       ]
;       (is (= expected-result centrality))
;     )
;   )
; )

; (deftest given-a-graph-calculate-the-closseness-centrality
;   (testing "given a graph calculate closseness centrality of a vertex v"
;     (let [
;         nodes [ ["A" "B"] ["B" "A"] ["B" "C"] ["C" "B"] ]
;         graph (build-graph-from nodes)
;         centrality (calculate-centrality-of "A" graph)
;         expected-result {:AB 1 :AC 2 }
;       ]
;       (is (= expected-result centrality))

;     )
;   )
; )