(ns loja.aula2)

;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]

(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))


;(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))))


(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))



(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)))


(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))


(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)))


(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))


(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))


(defn minha-funcao ([parametro1] (println parametro1))
  ([parametro1 parametro2] (println parametro1 parametro2)))

(minha-funcao 1)
(minha-funcao 1 2)


(defn conta ([elementos] (conta 0 elementos))

  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))


(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))