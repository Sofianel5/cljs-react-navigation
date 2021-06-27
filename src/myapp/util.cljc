(ns myapp.util
  (:refer-clojure :exclude [type])
  (:require [applied-science.js-interop :as j]
            [hx.react]
            [helix.core])
  #?(:cljs (:require-macros [sup.client.ui.lib.core :refer [defnc]])))

(defmacro defnc [type params & body]
  (let [default-opts {:helix/features {:fast-refresh true}}
        [opts body] (if (map? (first body))
                      [(first body) (rest body)]
                      [{} body])]
    `(helix.core/defnc ~type ~params
       ~(merge default-opts opts)
       (hx.react/f (do ~@body)))))


(defnc CenteredView [props]
  [hx.react/View {:style {:flex 1
                    :align-items "center"
                    :justify-content "center"}}
   (:children props)])

;; wrapper for console.log
(defn log [& args]
  (j/apply js/console :log (to-array args)))

;; pretty-print js object to string
(defn jpps [x]
  (j/call js/JSON :stringify x nil 2))
