(ns hospital.aula1
  (:use clojure.pprint))


(defn adiciona-paciente
  "Os pacientes são um map da seguinte forma -> pacientes { 15 {paciente 15}, 23 {paciente 23}"
  [pacientes paciente]
  (if-let [id (:id paciente)]
      (assoc pacientes id paciente)
                       (throw (ex-info "Paciete não possui id" {:paciente paciente}))))

(defn testa-uso-de-pacientes []
  (let [pacientes {}
        guilherme {:id 15 :nome "Guilherme" :nascimento "28/07/1995"}
        daniela {:id 20 :nome "Daniela" :nascimento "28/07/1995"}
        paulo {:nome "Paulo" :nascimento "23/07/1995"}]
    (pprint (adiciona-paciente pacientes guilherme))
    (pprint (adiciona-paciente pacientes daniela))
    (pprint (adiciona-paciente pacientes paulo))
    ))

;(testa-uso-de-

(defrecord Paciente [id nome nascimento])

(println (->Paciente 15 "Guilherme" "28/07/1995"))
(pprint (->Paciente 15 "Guilherme" "28/07/1995"))

(pprint (Paciente. 15 "Guilherme" "28/07/1995"))

(pprint(map->Paciente {:id 15, :nome "Guilherme", :nascimento "28/07/1995"}))


(let [guilherme (->Paciente 15 "Guilherme" "28/07/1995")]
  (println (:id guilherme))
  (println (vals guilherme)))

(pprint(map->Paciente {:id 15, :nome "Guilherme", :nascimento "28/07/1995" :rg 480337934}))
(pprint(map->Paciente {:id nil, :nome "Guilherme", :nascimento "28/07/1995" :rg 480337934}))
(pprint (.nome guilherme))


(pprint (assoc (Paciente. nil "Guilherme" "28/07/1995") :id 38))
(pprint (class (assoc (Paciente. nil "Guilherme" "28/07/1995") :id 38)))


(pprint (= (->Paciente 15 "Guilherme" "28/07/1995") (->Paciente 15 "Guilherme" "28/07/1995")))

