(ns hospital.core
  (:use [clojure pprint])
  (:require [hospital.model
             :as
             h.model]))


;ESPERA FILA DE ESPERA


;lab 1 -> 1 3
;lab 2 -> 2
;lab 3
;lab 4

(let [hospital-do-gui (h.model/novo-hospital)]
  (pprint hospital-do-gui))

(pprint h.model/fila_vazia)