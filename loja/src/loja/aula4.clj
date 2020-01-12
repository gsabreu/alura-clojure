(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logica :as l.logic]))


(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado ao contrário" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado por id" (sort-by :usuario-id resumo))

  ; update-in, assoc-in
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-por-usuario-ordenado [pedidos]
  (->> pedidos
       (sort-by :preco-total)))


(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo))
