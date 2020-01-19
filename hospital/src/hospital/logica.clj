(ns hospital.logica)

(defn cabe-na-fila? [hospital departamento]
  (-> hospital
      (get,,, departamento)
      count,,,
      (<,,, 5)))


(defn chega-em
  [hospital departamento pessoa]
  (if (cabe-na-fila? hospital departamento)
    (update hospital departamento conj pessoa)
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))
    ))

(defn chega-em-pausado
  [hospital departamento pessoa]
  (Thread/sleep (* (rand) 2000))
  (if (cabe-na-fila? hospital departamento)
    (do
      (update hospital departamento conj pessoa))
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))
    ))

(defn chega-em-pausado-logando
  [hospital departamento pessoa]
  (println "Tentando adicionar a pessoa" pessoa)
  (Thread/sleep (* (rand) 2000))
  (if (cabe-na-fila? hospital departamento)
    (do
      (println "dando uptadte nessa pessoa" pessoa)
      (update hospital departamento conj pessoa)
      )
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))
    ))

(defn atende
  [hospital departamento]
  (update hospital departamento pop)
  )


(defn proxima [hospital departamento]
  "Retorna o proximo paciente da fila"
  (-> hospital
      departamento
      peek))

(defn transfere
  "Transfe o proximo paciente da fila de para a fila para"
  [hospital de para]
  (let [pessoa (proxima hospital de)]
    (-> hospital
        (atende de)
        (chega-em para pessoa))))

