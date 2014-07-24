(ns centrality.traverse-test
  (:require [clojure.test :refer :all])
  (:use centrality.traverse)
)

(deftest basic-traverse-graph-dfs
  (testing "given a graph traverse nodes with dfs algorithm"
    (let [
        graph {:A ["B"] :B ["C"] :C []}
        result (traverse-graph-dfs graph :A)
      ]
      (println graph)
      (println result)
      (is (= [:A :B :C] result))
    )
  )
)
