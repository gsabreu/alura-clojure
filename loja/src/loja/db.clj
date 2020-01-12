(ns loja.db)

(def pedido1 {:usuario 15
              :item {:mochila { :id :mochila, :quantidade 2, :preco-unitario 10}
                     :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                     :tenis { :id :tenis, :quantidade 1}}})

(def pedido2 {:usuario 1
              :item {:mochila { :id :mochila, :quantidade 2, :preco-unitario 10}
                     :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                     :tenis { :id :tenis, :quantidade 1}}})

(def pedido3 {:usuario 15
              :item {:mochila { :id :mochila, :quantidade 2, :preco-unitario 10}
                     :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                     :tenis { :id :tenis, :quantidade 1}}})


(def pedido4 {:usuario 15
              :item {:mochila { :id :mochila, :quantidade 2, :preco-unitario 10}
                     :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                     :tenis { :id :tenis, :quantidade 1}}})

(def pedido5 {:usuario 10
              :item {:mochila { :id :mochila, :quantidade 20, :preco-unitario 10}
                     :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                     :tenis { :id :tenis, :quantidade 1}}})

(def pedido6 {:usuario 20
              :item {:mochila { :id :mochila, :quantidade 2, :preco-unitario 10}
                     :camiseta { :id :camiseta, :quantidade 10, :preco-unitario 40}
                     :tenis { :id :tenis, :quantidade 1}}})


(defn todos-os-pedidos []
  [pedido1 pedido2 pedido3 pedido4 pedido5 pedido6])