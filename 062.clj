(fn my-iterate [f x]
  (lazy-cat [x] (my-iterate f (f x))))

