(defn alor-descontado
  "Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9))

(valor-descontado 100)

(defn valor-descontado [valor-bruto] (* valor-bruto 0.9))
(valor-descontado 100)

(defn valor-descontado
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))

(valor-descontado 100)


(defn valor-descontado
"Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (let [desconto 0.10]
    (* valor-bruto (- 1 desconto))))

(valor-descontado 100)

(defn valor-descontado
"Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (* valor-bruto (- 1 desconto))))

(valor-descontado 100)

(defn valor-descontado
"Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]
    (println "Calculando taxa de desconto de" desconto)
    (- valor-bruto desconto)))

(valor-descontado 100)

(defn valor-descontado
"Retorna o valor descontado que é 90% do valor bruto com condicional"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando taxa de desconto de" desconto)
      (- valor-bruto desconto))
      valor-bruto))

(valor-descontado 1000)
(valor-descontado 100)
