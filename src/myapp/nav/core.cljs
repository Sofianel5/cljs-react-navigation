(ns myapp.nav.core
  (:require ["@react-navigation/native" :refer [NavigationContainer]]
            [myapp.nav.sub1 :as sub1]
            ;;[myapp.nav.sub2 :as sub2]
            [myapp.util :refer [defnc log jpps]]))

(defonce *nav-state (atom nil))

(defnc NavRoot [_]
  [NavigationContainer {:initialState (do (log "initial-state:\n" (jpps @*nav-state))
                                          @*nav-state)
                        :onStateChange (fn [x]
                                         (log "new-state:\n" (jpps x))
                                         (reset! *nav-state x))}
   [sub1/Root]])
