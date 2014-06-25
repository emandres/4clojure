(fn [x]
  (case (first (.toString x))
    \# :set
    \[ :vector
    \{ :map
    :list))
