(ns tackytoe.test-runner
  (:require
   [cljs.test :refer-macros [run-tests]]
   [tackytoe.core-test]))

(enable-console-print!)

(defn runner []
  (if (cljs.test/successful?
       (run-tests
        'tackytoe.core-test))
    0
    1))
