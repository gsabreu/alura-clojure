(ns introducao.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 2))
(println "Valor padrão nil" (get precos 17))
(println "Valor padrão 0" (get precos 17 0))
(println "valor padrao 0, mas existe" (get precos 2 0))


(println (conj precos 5))

(println precos)

(println (inc 5))

(println (update precos 0 inc))
(println (update precos 1 dec))
(println precos)

(defn soma-1 [valor]
  (println "Estou somando um em " valor)
  (+ valor 1))

(println (update precos 0 soma-1))

(defn soma-3 [valor]
  (println "Estou somando tres em " valor)
  (+ valor 3))

(println (update precos 1 soma-3))

;Codigo da aula anterior

(defn aplica-desconto? [valor-bruto] (> valor-bruto 100))

(defn valor-descontado [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println "meus preços" precos)

;MAP

(println "map" (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))

(println "Vetor" precos)
(println "filter" (filter aplica-desconto? precos))

(println "Map apos o filter" (map valor-descontado (filter aplica-desconto? precos)))

;REDUCE e Variações

(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))
(println (reduce minha-soma [15]))

(println (reduce minha-soma 0 precos))
(println (reduce minha-soma 0 (range 10)))
(println (reduce minha-soma 0 [15]))

