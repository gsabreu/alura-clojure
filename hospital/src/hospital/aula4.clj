(ns hospital.aula4
  (:use [clojure pprint])
  (:require [hospital.logica :as h.logic]
            [hospital.model :as h.model]))


(defn chega-sem-malvado! [hospital pessoa]
  (swap! hospital h.logic/chega-em :espera pessoa)
  (println "Apos inserir" pessoa)
  )


;; Muito claro o problema de variavel global (simbolo do namespace) compartilhada
(defn simula-um-dia-em-paralelo-com-mapv
  "Simulação utilizando mapv para forçar a execução do que era Lazy"
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]]

    (mapv #(.start (Thread. (fn [] (chega-sem-malvado! hospital %)))) pessoas)
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

;(simula-um-dia-em-paralelo)


(defn simula-um-dia-em-paralelo-com-mapv-refatorada
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        starta-thread-de-chegada #(.start (Thread. (fn [] (chega-sem-malvado! hospital %))))]

    (mapv starta-thread-de-chegada pessoas)
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))


;(simula-um-dia-em-paralelo-com-mapv-refatorada)
;------------------------------------------------------------------------------------------------

(defn starta-thread-de-chegada
  ([hospital]
   (fn [pessoa] (starta-thread-de-chegada hospital pessoa)))
  ([hospital pessoa]
   (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa))))))


(defn simula-um-dia-em-paralelo-com-mapv-refatorada-e-extraida
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        starta (starta-thread-de-chegada hospital)]

    (mapv starta pessoas)
    (.start (Thread. (fn [] (Thread/sleep 4000)
                       (pprint hospital))))))


;(simula-um-dia-em-paralelo-com-mapv-refatorada-e-extraida)


(defn starta-thread-de-chegada-partial
  [hospital pessoa]
   (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa)))))


(defn simula-um-dia-em-paralelo-com-partial
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        starta (partial starta-thread-de-chegada-partial hospital)]

    (mapv starta pessoas)
    (.start (Thread. (fn [] (Thread/sleep 4000)
                       (pprint hospital))))))


(simula-um-dia-em-paralelo-com-partial)