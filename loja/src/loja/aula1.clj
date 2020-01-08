(ns loja.aula1)

;["daniela" "guilherme" "carlos" "paulo" "lucia"]
;[ "guilherme" 37 , "paulo" 39]
;'(1 2 3 4 5)
;[[0 1]]
;#{}


;map -> passar por varios elementos e retornar o resultado
;reduce -> reduzir para um resultado
;filter -> filtrar

(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest []))
(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (next []))
(println (seq []))
(println (seq [1 2 3 4 5]))

(println "\n\n\n\nMEU MAPA")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))

;(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (primeiro first)
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])


(meu-mapa println ["daniela" false "guilherme" "carlos" "paulo" "lucia" "ana"])