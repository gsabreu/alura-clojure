(ns hospital.aula3
  (:use [clojure pprint])
  (:require [hospital.logica :as h.logic]
            [hospital.model :as h.model]))

;simbolo que qualquer thread que acessar terá acesso (PUBLIC)
(def nome "guilherme")


(let [nome "guilherme"]
  ;coisa1
  ;coisa2
  (println nome)
  (let [nome "danila"]
    ;coisa 3
    ;coisa 4
    (println nome))

  (println nome)
  )

(defn testa-atomao []
  (let [hospital-silveira (atom {:espera h.model/fila_vazia})]
    (println hospital-silveira)
    (pprint hospital-silveira)

    (pprint (deref hospital-silveira))
    (pprint @hospital-silveira)

    ;Nao altero conteudo do atomo dessa maneira
    (pprint (assoc @hospital-silveira :laboratorio1 h.model/fila_vazia))
    (pprint @hospital-silveira)

    ;uma das maneiras de alterar conteudo de um atomo
    (swap! hospital-silveira assoc :laboratorio1 h.model/fila_vazia)
    (pprint hospital-silveira)

    (swap! hospital-silveira assoc :laboratorio2 h.model/fila_vazia)
    (pprint hospital-silveira)

    ;update tradicional  imutavel com deferecencia, nao trara efeito
    (update @hospital-silveira :laboratorio1 conj "111")

    ;indo para o swap
    (swap! hospital-silveira update :laboratorio1 conj "111")
    (pprint hospital-silveira)
    ))

;(testa-atomao)

(defn chega-em-malvado! [hospital pessoa]
  (swap! hospital h.logic/chega-em-pausado-logando :espera pessoa)
  (println "Apos inserir" pessoa)
  )


;; Muito claro o problema de variavel global (simbolo do namespace) compartilhada
(defn simula-um-dia-em-paralelo
  []
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-em-malvado! hospital "111"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "222"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "333"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "444"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "555"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

;(simula-um-dia-em-paralelo)


(defn chega-sem-malvado! [hospital pessoa]
  (swap! hospital h.logic/chega-em :espera pessoa)
  (println "Apos inserir" pessoa)
  )


;; Muito claro o problema de variavel global (simbolo do namespace) compartilhada
(defn simula-um-dia-em-paralelo
  []
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "111"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "222"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "333"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "444"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "555"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))
;sem forçar o retry (busy retr) [pode acontecer, mas pode não acontecer
(simula-um-dia-em-paralelo)