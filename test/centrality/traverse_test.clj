(ns centrality.traverse-test
  (:require [clojure.test :refer :all])
  (:use centrality.traverse)
)

(deftest basic-traverse-graph-dfs
  (testing "given a graph traverse nodes with dfs algorithm"
    (let [
        graph {:A ["B"] :B ["C"]}
        result (traverse-graph-dfs graph :A)
      ]
      (is (= [:A :B :C] result))
    )
  )
)

(deftest basic-seq-graph-dfs
  (testing "given a graph traverse nodes with seq-dfs algorithm"
    (let [
        graph {:A ["B"] :B ["C"]}
        result (seq-graph-dfs graph :A)
      ]
      (is (= [:A :B :C] result))
    )
  )
)
