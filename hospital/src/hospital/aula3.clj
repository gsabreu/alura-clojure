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
  (let [hospital-silveira (atom { :espera h.model/fila_vazia})]
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

(testa-atomao)