(ns myapp.util
  (:require ["react-native" :as rn]
            [applied-science.js-interop :as j]
            [hx.react :as hx]))

(hx/defnc CenteredView [props]
  [rn/View {:style {:flex 1, :align-items "center", :justify-content "center"}}
   (:children props)])

;; wrapper for console.log
(defn log [& args]
  (j/apply js/console :log (to-array args)))

;; pretty-print js object to string
(defn jpps [x]
  (j/call js/JSON :stringify x nil 2))
