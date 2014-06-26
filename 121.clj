(ns p121
  (:use clojure.test))

(defn c
  [expr]
  (fn [env]
    (let [env (merge env {'+ +
                          '- -
                          '* *
                          '/ /})]
      (cond 
        (list? expr) (apply (env (first expr)) 
                            (map #((c %) env)
                                 (rest expr)))
        (symbol? expr) (env expr)
        :else expr))))

(deftest eval-constants
  (is (= 2 ((c 2) {}))))

(deftest eval-variables
  (is (= 2 ((c 'b) '{b 2}))))

(deftest eval-func
  (is (= 2 ((c '(+ 1 1)) {}))))

(deftest example-1
  (is (= 2 ((c '(/ a b))
            '{b 8 a 16}))))
  
(run-all-tests)

