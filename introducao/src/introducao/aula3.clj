(ns introducao.aula3)

(defn valor-descontado
  "Retorna o valor descontado que é 90% do valor bruto com condicional"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))
(println (valor-descontado 100))


;Predicate
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))

(defn valor-descontado
  "Retorna o valor descontado que é 90% do valor bruto com condicional"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))
(println (valor-descontado 100))

; When (if apenas com true) retorna nil se for falso
(defn aplica-desconto?
  [valor-bruto]
  (println "Chamando a versão when")
  (when (> valor-bruto 100)
    true))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))
(println (valor-descontado 1000))
(println (valor-descontado 100))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))
(println (valor-descontado 1000))
(println (valor-descontado 100))

(defn mais-caro-que-100?
  [valor-bruto]
  (println "Chamando a versão mais caro que 100")
  (when (> valor-bruto 100)
    true))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println "Função mais caro que 100")
(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))

; HIGHER ORDER FUNCTIONS
; IMUTABILIDADE

(defn mais-caro-que-100? [valor-bruto] (> valor-bruto 100))

(println "Função sem nome. anonima")
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado(fn [valor-bruto] (> valor-bruto 100)) 100))

;Função sem nome com # e parametro %1 (um parametro)
(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))

;Função sem nome com # e parametro % (um parametro)
(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))

;Define simbolo como função
(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100)))
(def mais-caro-que-100? #(> %1 100))
(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))