(ns hospital.aula2
  (:use clojure.pprint))



(defrecord Paciente [id, nome, nascimento])

; Paciente plano de saude ====> + plano de saude
; Paciente Particular ---> + 0

(defrecord PacienteParticular [id, nome, nascimento])
(defrecord PacientePlanoDeSaude [id, nome, nascimento, plano])


(defn deve-assinar-pre-autorizacao? [paciente procedimento valor]
  (if (= PacienteParticular (type paciente))
    (>= valor 50)
    ;assumindo que existe os dois tipos
    (if (= PacientePlanoDeSaude (type paciente))
      (let [plano (get paciente :plano)]
        (not (some #(= % procedimento) plano)))
      true)))