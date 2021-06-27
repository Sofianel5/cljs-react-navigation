(ns myapp.main
  (:require ["react-native" :as rn]
            [applied-science.js-interop :as j]
            [hx.react :as hx]
            [myapp.nav.core :as nav]
            [myapp.util :refer [defnc]]))

(defonce *root-wrapper (atom nil))

(defnc RootWrapper
  [nav/NavRoot])

(defn start {:dev/after-load true} []
  (if-let [rw @*root-wrapper]
    (j/call rw :forceUpdate)
    (rn/AppRegistry.registerComponent "MyApp" (fn [] RootWrapper))))

(defn init []
  (start))
