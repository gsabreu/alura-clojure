(ns hospital.colecoes
  (:use [clojure pprint]))


;;; ENTRA NO FINAL E SAI NO COMEÇO
(defn testa-vetor []
  (let [espera [111 222]]
    (println "VETOR")
    (println espera)
    (println (conj espera 333))
    (println (conj espera 444))
    (println (pop espera))
    ))
(testa-vetor)


;;; ENTRA NO COMECO E SAI NO FINAL
(defn testa-lista []
  (let [espera '(111 222)]
    (println "LISTA")
    (println espera)
    (println (conj espera 333))
    (println (conj espera 444))
    (println (pop espera))
    ))

(testa-lista)


;;; ENTRA NO COMECO E SAI NO FINAL
(defn testa-conjunto []
  (let [espera #{111 222}]
    (println "CONJUNTO")
    (println espera)
    (println (conj espera 111))
    (println (conj espera 333))
    (println (conj espera 444))
    ; (println (pop espera)) Não rola POP em set
    ))

(testa-conjunto)


;;; ENTRA NO FINAL E SAI NO COMEÇO ->> FILA (FIFO)
(defn testa-fila []
  (let [espera (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
    (println "FILA")
    (println (seq espera))
    (println (seq (conj espera "333")))
    (println (seq (pop espera)))
    (println (peek espera))
    (pprint espera)
    ))

(testa-fila)