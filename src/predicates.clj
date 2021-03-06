(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string) (empty? string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn book-has-award [book]
  (fn [a] (has-award? book a)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (book-has-award book) awards))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [m (map pred a-seq)]
    (empty? (filter false? m))))

(defn divides? [n]
  (fn [a] 
    (= (mod n a) 0)))

(defn prime? [n]
  (let [pred (divides? n)]
    (not (some pred (range 2 n)))))

;^^
