(ns introducao.aula6)


(def pedido {:mochila {:quantidade 2, :preco 80 }
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor)
  15)

(println (map imprime-e-15 pedido))

;(defn imprime-e-15 [chave valor]
;  (println chave "e" valor)
;  15)
;
;(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  15)

(println (map imprime-e-15 pedido))


(defn imprime-e-15 [[chave valor]]
  valor)

(println (map imprime-e-15 pedido))

(defn preco-dos-produto [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produto pedido))
(println (reduce + (map preco-dos-produto pedido)))

(defn preco-dos-produto [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produto pedido))
(println (reduce + (map preco-dos-produto pedido)))


(defn total-de-pedidos [pedido]
  (reduce + (map preco-dos-produto pedido)))

(println (total-de-pedidos pedido))



(defn preco-total-dos-pedidos [produto]
  (* (:quantidade produto) (:preco produto)))

;THREAD LAST
(defn total-do-pedido [pedido]
  (->> pedido
      (map preco-total-dos-pedidos ,,,)
      (reduce + ,,,)))

(println (total-de-pedidos pedido))


(def pedido {:mochila {:quantidade 2, :preco 80 }
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1, :preco 0}})


(defn gratuito? [item]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter (fn [[chave item]] (gratuito? item)) pedido))

(println (filter #(gratuito? (second %)) pedido))

(defn pago? [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))


(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))





