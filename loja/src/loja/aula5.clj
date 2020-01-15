(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logica :as l.logic]))


(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo))
  (println "filter" (filter gastou-bastante? resumo))
  )


(println "Tentando entender dentro do keep e do filter")

(defn gastou-bastante? [info-do-usuario]
  (println "gastou bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))


(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo))
  )


(println "Vamos isolar ...")

(println (range 10))
(println (take 2 (range 100000000000000)))

; a sequêncianão esta sendo "gulosa" EAGER

(let [sequencia (range 10000000)]
  (println (take 2 sequencia)))

; a sequêncianão esta sendo LAZY


(defn filtro1 [x]
  (println "filtro1" x)
  x)

(println (map filtro1 (range 10)))


(defn filtro2 [x]
  (println "filtro2" x)
  x)

(println (map filtro2 (map filtro1 (range 10))))



(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

;CHUNCKS DE 32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)


(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)


(->> [0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5]
     (map filtro1)
     (map filtro2)
     println)

; lista ligada 100% lazy
(->> '(0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5)
     (map filtro1)
     (map filtro2)
     println)