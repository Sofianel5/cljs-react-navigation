(ns myapp.nav.sub2
  (:require ["react-native" :as rn]
            [myapp.util :refer-macros [defnc] :refer [CenteredView]]))

(defnc TabB [_]
  [CenteredView
   [rn/Text {:style {:font-size 36}}
    "Tab B"]])
